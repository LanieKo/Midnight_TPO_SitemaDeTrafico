package modelo;

// Comuna: subdivisión de la Ciudad
public class Comuna {

    public String nombre;
    private Barrio[] barrios;
    private int cantBarrios;
    private static final int MAX_BARRIOS = 15;

    public Comuna(String nombre) {
        this.nombre = nombre;
        this.barrios = new Barrio[MAX_BARRIOS];
        this.cantBarrios = 0;
    }

    public boolean agregarBarrios(Barrio barrio) {
        if (cantBarrios == MAX_BARRIOS) {
            System.out.println("Comuna " + nombre + ": máximo de barrios alcanzado.");
            return false;
        }
        barrios[cantBarrios] = barrio;
        cantBarrios++;
        return true;
    }

    public Barrio[] obtenerBarrios() {
        return barrios;
    }

}
