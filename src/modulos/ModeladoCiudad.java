package modulos;

import tda.GrafoPonderado;
import modelo.Interseccion;
import modelo.Calle;

// MÓDULO 1 - Modelado de la Ciudad
// TDA utilizado: Grafo con Matriz de Adyacencia Ponderada (GrafoPonderado)
// Basado en grafo1/GrafoMatrizAdyacencia.java de la materia
// Vértices: objetos Interseccion | Aristas: objetos Calle con distancia
// Permite: BFS para verificar rutas y Dijkstra para ruta más corta
public class ModeladoCiudad {

    private GrafoPonderado<String> grafoCiudad;
    private Interseccion[] intersecciones;
    private int cantIntersecciones;
    private int capacidad;

    public ModeladoCiudad(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.grafoCiudad = new GrafoPonderado<>(capacidad, dirigido);
        this.intersecciones = new Interseccion[capacidad];
        this.cantIntersecciones = 0;
    }

    // Registra una intersección como vértice del grafo
    public void agregarInterseccion(Interseccion interseccion) {
        if (cantIntersecciones == capacidad) {
            System.out.println("Error: capacidad máxima de intersecciones alcanzada.");
            return;
        }
        grafoCiudad.insertarVertice(interseccion.getId());
        intersecciones[cantIntersecciones] = interseccion;
        cantIntersecciones++;
        System.out.println("Intersección registrada: " + interseccion);
    }

    // Registra una calle (arista) entre dos intersecciones existentes
    public void agregarCalle(Calle calle, String idOrigen, String idDestino) {
        if (!grafoCiudad.existeVertice(idOrigen) || !grafoCiudad.existeVertice(idDestino)) {
            System.out.println("Error: una de las intersecciones no existe en la red.");
            return;
        }
        // conectarInterseccion() del modelo Calle
        Interseccion a = buscarInterseccion(idOrigen);
        Interseccion b = buscarInterseccion(idDestino);
        if (a != null && b != null) {
            calle.conectarInterseccion(a, b);
        }
        grafoCiudad.insertarArista(idOrigen, idDestino, calle.distancia);
    }

    // BFS: verifica si existe alguna ruta entre dos intersecciones
    public boolean existeRuta(String idOrigen, String idDestino) {
        boolean existe = grafoCiudad.existeRuta(idOrigen, idDestino);
        if (existe) {
            System.out.println("Existe ruta entre " + idOrigen + " y " + idDestino + ".");
        } else {
            System.out.println("No existe ruta entre " + idOrigen + " y " + idDestino + ".");
        }
        return existe;
    }

    // Dijkstra: calcula y muestra la distancia mínima entre dos puntos
    public void calcularRutaMasCorta(String idOrigen, String idDestino) {
        System.out.println("\n--- Cálculo de ruta más corta ---");
        grafoCiudad.mostrarRutaMasCorta(idOrigen, idDestino);
    }

    public void mostrarRed() {
        System.out.println("\n--- Red Vial de la Ciudad ---");
        grafoCiudad.mostrarVertices();
        grafoCiudad.mostrarMatriz();
    }

    // Busca el objeto Interseccion por su ID
    public Interseccion buscarInterseccion(String id) {
        for (int i = 0; i < cantIntersecciones; i++) {
            if (intersecciones[i].getId().equals(id)) {
                return intersecciones[i];
            }
        }
        return null;
    }
}
