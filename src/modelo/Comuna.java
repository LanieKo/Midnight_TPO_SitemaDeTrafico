package modelo;

// Comuna: subdivisión de la Ciudad (equivalente a "Zona" del borrador)
// Atributos: nombre, barrios (según UML propuesto)
// Métodos: agregarBarrios(), obtenerBarrios()
public class Comuna {

    private String nombre;
    private Barrio[] barrios;
    private int cantBarrios;
    private static final int MAX_BARRIOS = 15;

    public Comuna(String nombre) {
        this.nombre = nombre;
        this.barrios = new Barrio[MAX_BARRIOS];
        this.cantBarrios = 0;
    }

    // agregarBarrios() según el UML propuesto
    public boolean agregarBarrios(Barrio barrio) {
        if (cantBarrios == MAX_BARRIOS) {
            System.out.println("Comuna " + nombre + ": máximo de barrios alcanzado.");
            return false;
        }
        barrios[cantBarrios] = barrio;
        cantBarrios++;
        return true;
    }

    // obtenerBarrios() según el UML propuesto
    public Barrio[] obtenerBarrios() {
        return barrios;
    }

    public String getNombre()    { return nombre; }
    public int getCantBarrios()  { return cantBarrios; }

    @Override
    public String toString() { return "Comuna " + nombre; }
}
