package modulos;

import tda.ColaPrioridad;
import modelo.Emergencia;
import modelo.UnidadEmergencia;

// MÓDULO 2 - Despacho de Emergencias
// TDA utilizado: Cola con Prioridad (ColaPrioridad)
// Basado en el PDF claseAbril10_ColaCircularyConPrioridad.pdf de la materia
// Mayor gravedad → mayor prioridad → se atiende primero
// Usa el modelo Emergencia y UnidadEmergencia (según UML propuesto)
public class DespachoEmergencias {

    private ColaPrioridad cola;
    private Emergencia[] registroEmergencias;  // referencia a los objetos Emergencia
    private int contadorId;
    private int capacidadMaxima;

    public DespachoEmergencias(int capacidadMaxima) {
        this.cola = new ColaPrioridad(capacidadMaxima);
        this.registroEmergencias = new Emergencia[capacidadMaxima];
        this.contadorId = 1;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Reporta una emergencia y la agrega a la Cola con Prioridad
    // La Emergencia se construye con los datos y su gravedad define la prioridad
    public void reportarEmergencia(String descripcion, int gravedad, String ubicacion, String hora) {
        if (gravedad < 1 || gravedad > 10) {
            System.out.println("Error: la gravedad debe estar entre 1 y 10.");
            return;
        }
        int id = contadorId++;
        Emergencia e = new Emergencia(id, gravedad, ubicacion, hora, descripcion);
        // Se guarda la referencia al objeto Emergencia
        registroEmergencias[id - 1] = e;
        boolean insertada = cola.insertar(id, gravedad, descripcion);
        if (insertada) {
            System.out.println("Emergencia reportada: " + e);
        }
    }

    // Despacha la emergencia de mayor gravedad
    // Si hay una UnidadEmergencia disponible, la asigna
    public void despacharSiguiente(UnidadEmergencia unidad) {
        if (cola.estaVacia()) {
            System.out.println("No hay emergencias pendientes para despachar.");
            return;
        }
        ColaPrioridad.Elemento elem = cola.eliminar();
        System.out.println(">> DESPACHANDO emergencia ID: " + elem.dato);
        // Recuperar el objeto Emergencia y asignar la unidad
        if (unidad != null) {
            Emergencia e = registroEmergencias[elem.dato - 1];
            if (e != null) {
                unidad.atenderEmergencia(e);
            }
        }
    }

    // Overload sin unidad (solo despacha)
    public void despacharSiguiente() {
        despacharSiguiente(null);
    }

    public void verProximaEmergencia() {
        if (cola.estaVacia()) {
            System.out.println("No hay emergencias pendientes.");
            return;
        }
        System.out.println("Próxima emergencia a atender: " + cola.frente());
    }

    public int cantidadPendientes() { return cola.tamanio(); }

    public void mostrarTodasLasEmergencias() {
        System.out.println("\n--- Estado actual del Despacho ---");
        cola.mostrar();
        System.out.println("Total pendientes: " + cola.tamanio());
    }
}
