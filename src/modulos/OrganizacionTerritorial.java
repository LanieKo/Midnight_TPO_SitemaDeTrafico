package modulos;

import tda.ArbolGeneral;
import tda.ArbolGeneral.NodoGeneral;
import modelo.Ciudad;
import modelo.Comuna;
import modelo.Barrio;
import modelo.Manzana;

// MÓDULO 4 - Organización Territorial

public class OrganizacionTerritorial {

    private ArbolGeneral<String> arbolTerritorial;  //Preguntar a la profe si sacamos <String>
    private Ciudad ciudad;

    public OrganizacionTerritorial() {
        arbolTerritorial = new ArbolGeneral<>();
        ciudad = null;
    }

    // Inicializa la ciudad como raíz del árbol (Ciudad → raíz)
    public void crearCiudad(String nombreCiudad) {
        ciudad = new Ciudad(nombreCiudad);
        arbolTerritorial.crearRaiz(nombreCiudad, 20);
        //System.out.println("Ciudad creada: " + nombreCiudad);
    }

    // Agrega una comuna (reemplaza "Zona" del borrador) como hijo de la raíz
    public NodoGeneral<String> agregarComuna(String nombreComuna) {   //Preguntar a la profe si sacamos <String>
        NodoGeneral<String> raiz = arbolTerritorial.getRaiz();  //Preguntar a la profe si sacamos <String>
        if (raiz == null) {
            System.out.println("Error: primero debe crear la ciudad.");
            return null;
        }
        // Modelo: agregarComunas() de Ciudad
        Ciudad ciudadObj = getCiudad();
        if (ciudadObj != null) {
            ciudadObj.agregarComunas(new Comuna(nombreComuna));
        }
        boolean ok = arbolTerritorial.agregarHijo(raiz, nombreComuna, 15);
        if (ok) {
            //System.out.println("Comuna agregada: " + nombreComuna);
            return arbolTerritorial.buscar(nombreComuna);
        }
        return null;
    }

    // Agrega un barrio a una comuna existente - buscarComuna() + agregarBarrios()
    public NodoGeneral<String> agregarBarrio(String nombreComuna, String nombreBarrio) {  //Preguntar a la profe si sacamos <String>
        NodoGeneral<String> nodoComuna = arbolTerritorial.buscar(nombreComuna);   //Preguntar a la profe si sacamos <String>
        if (nodoComuna == null) {
            System.out.println("Comuna no encontrada: " + nombreComuna);
            return null;
        }
        // Modelo: agregarBarrios() de Comuna
        if (ciudad != null) {
            Comuna c = ciudad.buscarComuna(nombreComuna);
            if (c != null) {
                c.agregarBarrios(new Barrio(nombreBarrio));
            }
        }
        boolean ok = arbolTerritorial.agregarHijo(nodoComuna, nombreBarrio, 30);
        if (ok) {
            //System.out.println("Barrio agregado: " + nombreBarrio + " → Comuna: " + nombreComuna);
            return arbolTerritorial.buscar(nombreBarrio);
        }
        return null;
    }

    // Agrega una manzana a un barrio existente - agregarManzana() del modelo Barrio
    public void agregarManzana(String nombreBarrio, String codigoManzana) {
        NodoGeneral<String> nodoBarrio = arbolTerritorial.buscar(nombreBarrio);   //Preguntar a la profe si sacamos <String>
        if (nodoBarrio == null) {
            System.out.println("Barrio no encontrado: " + nombreBarrio);
            return;
        }
        boolean ok = arbolTerritorial.agregarHijo(nodoBarrio, "Manzana " + codigoManzana, 0);
        if (ok) {
            //System.out.println("Manzana " + codigoManzana + " agregada → Barrio: " + nombreBarrio);
        }
    }

    // Muestra la estructura jerárquica completa (equivalente a mostrarArbol() del AVL)
    public void mostrarEstructura() {
        System.out.println("\n--- Organización Territorial ---");
        arbolTerritorial.mostrarArbol();
    }

    // Muestra la estructura por niveles (equivalente a mostrarPorNiveles() del AVL)
    public void mostrarPorNiveles() {
        System.out.println("\n--- Estructura por Niveles ---");
        arbolTerritorial.mostrarPorNiveles();
    }

    // Busca y muestra información de un territorio
    public void buscarTerritorio(String nombre) {
        NodoGeneral<String> nodo = arbolTerritorial.buscar(nombre);
        if (nodo != null) {
            System.out.println("Territorio encontrado: " + nodo.dato
                    + " | Subdivisiones directas: " + nodo.cantHijos);
        } else {
            System.out.println("Territorio no encontrado: " + nombre);
        }
    }

    public Ciudad getCiudad()       {
        return ciudad;
    }
    public int totalTerritorios()   {
        return arbolTerritorial.cantidadNodos();
    }
}
