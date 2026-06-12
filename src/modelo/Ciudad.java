package modelo;

// Ciudad: raíz de la organización territorial
// Atributos: nombre, comunas (según UML propuesto)
// Métodos: agregarComunas(), buscarComuna()
public class Ciudad {

    private String nombre;
    private Comuna[] comunas;
    private int cantComunas;
    private static final int MAX_COMUNAS = 20;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.comunas = new Comuna[MAX_COMUNAS];
        this.cantComunas = 0;
    }

    // agregarComunas() según el UML propuesto
    public boolean agregarComunas(Comuna comuna) {
        if (cantComunas == MAX_COMUNAS) {
            System.out.println("Ciudad " + nombre + ": máximo de comunas alcanzado.");
            return false;
        }
        comunas[cantComunas] = comuna;
        cantComunas++;
        return true;
    }

    // buscarComuna() según el UML propuesto
    public Comuna buscarComuna(String nombreComuna) {
        for (int i = 0; i < cantComunas; i++) {
            if (comunas[i].getNombre().equalsIgnoreCase(nombreComuna)) {
                return comunas[i];
            }
        }
        return null;
    }

    public String getNombre()   { return nombre; }
    public int getCantComunas() { return cantComunas; }
    public Comuna[] getComunas(){ return comunas; }

    @Override
    public String toString() { return "Ciudad " + nombre; }
}
