package modulos;

import modelo.Interseccion;
import modelo.Vehiculo;

// MÓDULO 5 - Flujo Vehicular en Intersecciones

public class FlujoVehicular {

    private Interseccion interseccion;

    public FlujoVehicular(Interseccion interseccion) {
        this.interseccion = interseccion;
    }

    // Delega en agregarVehiculo() de Interseccion - O(1) encolar
    public void llegadaVehiculo(Vehiculo vehiculo) {
        interseccion.agregarVehiculo(vehiculo);
    }

    // Delega en liberarVehiculo() de Interseccion - O(1) desencolar FIFO
    public Vehiculo liberarVehiculo() {
        return interseccion.liberarVehiculo();
    }

    // Muestra el próximo vehículo sin liberarlo, indica hacia qué calle iría
    public void verProximo(String calleDestino) {
        interseccion.tomarCalle(calleDestino);
    }

    public int cantidadEnEspera() {
        return interseccion.cantVehiculosEnEspera();
    }

    public void mostrarCola() {
        interseccion.mostrarCola();
    }

    public Interseccion getInterseccion() {
        return interseccion;
    }


}
