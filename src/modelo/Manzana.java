package modelo;

// Manzana: subdivisión de un Barrio
// Atributos: codigo, calles (según UML propuesto)
// Método: agregarCalle()
public class Manzana {

    private String codigo;
    private String[] calles;
    private int cantCalles;
    private static final int MAX_CALLES = 20;

    public Manzana(String codigo) {
        this.codigo = codigo;
        this.calles = new String[MAX_CALLES];
        this.cantCalles = 0;
    }

    // agregarCalle() según el UML propuesto
    public boolean agregarCalle(String nombreCalle) {
        if (cantCalles == MAX_CALLES) {
            System.out.println("Manzana " + codigo + ": máximo de calles alcanzado.");
            return false;
        }
        calles[cantCalles] = nombreCalle;
        cantCalles++;
        return true;
    }

    public String getCodigo()  { return codigo; }
    public int getCantCalles() { return cantCalles; }

    @Override
    public String toString() { return "Manzana " + codigo; }
}
