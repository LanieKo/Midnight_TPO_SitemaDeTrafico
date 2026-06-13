package modelo;

// Vehículo que circula por la red vial

public class Vehiculo {

    public enum Tipo { AUTO, MOTO, CAMION, AMBULANCIA, BOMBEROS }

    private String patente;
    private Tipo tipo;

    public Vehiculo(String patente, Tipo tipo) {
        if (patente == null || patente.isEmpty()) {
            throw new IllegalArgumentException("La patente no puede estar vacía.");
        }
        this.patente = patente;
        this.tipo = tipo;
    }

    public void avanzar(String destino) {
        System.out.println("Vehículo " + patente + " [" + tipo + "] avanzando hacia: " + destino);
    }

    public String getPatente() {
        return patente;
    }
    public Tipo getTipo()      {
        return tipo;
    }

    @Override
    public String toString() {
        return patente + " [" + tipo + "]";
    }
}
