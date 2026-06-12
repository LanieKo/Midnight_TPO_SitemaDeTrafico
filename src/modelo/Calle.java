package modelo;

// Calle: arista de la red vial
// Atributos: nombre, distancia, intersecciones (según UML propuesto)
// Método: conectarInterseccion()
public class Calle {

    private String nombre;
    private int distancia;        // en metros
    private Interseccion extremoA;
    private Interseccion extremoB;

    public Calle(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    // conectarInterseccion() según el UML propuesto
    public void conectarInterseccion(Interseccion a, Interseccion b) {
        this.extremoA = a;
        this.extremoB = b;
        System.out.println("Calle '" + nombre + "' conecta: "
                + a.getNombre() + " <-> " + b.getNombre()
                + " (" + distancia + "m)");
    }

    public String getNombre()          { return nombre; }
    public int getDistancia()          { return distancia; }
    public Interseccion getExtremoA()  { return extremoA; }
    public Interseccion getExtremoB()  { return extremoB; }

    @Override
    public String toString() {
        String aStr = (extremoA != null) ? extremoA.getNombre() : "?";
        String bStr = (extremoB != null) ? extremoB.getNombre() : "?";
        return "'" + nombre + "' [" + aStr + " <-> " + bStr + ", " + distancia + "m]";
    }
}
