package modelo;

// Barrio: subdivisión de una Comuna
// Atributos: nombre, manzanas (según UML propuesto)
// Método: agregarManzana()
public class Barrio {

    private String nombre;
    private Manzana[] manzanas;
    private int cantManzanas;
    private static final int MAX_MANZANAS = 30;

    public Barrio(String nombre) {
        this.nombre = nombre;
        this.manzanas = new Manzana[MAX_MANZANAS];
        this.cantManzanas = 0;
    }

    // agregarManzana() según el UML propuesto
    public boolean agregarManzana(Manzana manzana) {
        if (cantManzanas == MAX_MANZANAS) {
            System.out.println("Barrio " + nombre + ": máximo de manzanas alcanzado.");
            return false;
        }
        manzanas[cantManzanas] = manzana;
        cantManzanas++;
        return true;
    }

    public String getNombre()     { return nombre; }
    public int getCantManzanas()  { return cantManzanas; }
    public Manzana[] getManzanas(){ return manzanas; }

    @Override
    public String toString() { return "Barrio " + nombre; }
}
