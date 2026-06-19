package modelo;

import tda.Cola;

// Interseccion: nodo de la red vial
// Los vehículos se administran en una Cola FIFO (orden de llegada)
public class Interseccion {

    private String id;
    private String nombre;
    private Cola<Vehiculo> vehiculosEnEspera;   // TDA Cola para flujo vehicular

    public Interseccion(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.vehiculosEnEspera = new Cola<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculosEnEspera.encolar(v);
        //System.out.println("Vehículo " + v + " llegó a " + nombre + " | En espera: " + vehiculosEnEspera.tamanio());
    }

    // liberarVehiculo() según el UML propuesto - FIFO estricto
    public Vehiculo liberarVehiculo() {
        if (vehiculosEnEspera.estaVacia()) {
            System.out.println("No hay vehículos esperando en " + nombre + ".");
            return null;
        }
        Vehiculo v = vehiculosEnEspera.desencolar();
        System.out.println("Vehículo " + v + " liberado de " + nombre  + " | Restantes: " + vehiculosEnEspera.tamanio());
        return v;
    }

    // informa la calle que toma el próximo vehículo
    public void tomarCalle(String nombreCalle) {
        Vehiculo proximo = vehiculosEnEspera.recuperarFrente();
        if (proximo != null) {
            System.out.println("Próximo vehículo " + proximo + " tomará calle: " + nombreCalle);
        } else {
            System.out.println("No hay vehículos en espera en " + nombre + ".");
        }
    }

    public int cantVehiculosEnEspera() {
        return vehiculosEnEspera.tamanio();
    }

    public void mostrarCola() {
        System.out.print("Intersección " + nombre + " (" + id + ") --> ");
        vehiculosEnEspera.mostrar();
    }

    public String getId()     {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() { // Preguntar si lo dejamos
        return nombre + " (" + id + ")";
    }
}
