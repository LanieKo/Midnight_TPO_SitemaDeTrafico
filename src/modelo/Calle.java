package modelo;

// Calle: arista de la red vial

public class Calle {

    private String nombre;
    public int distancia;        // en metros
    private Interseccion extremoA;
    private Interseccion extremoB;

    public Calle(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    // conectarInterseccion()
    public void conectarInterseccion(Interseccion a, Interseccion b) {
        this.extremoA = a;
        this.extremoB = b;
        //System.out.println("Intersecciones conectadas por la calle " + nombre);
    }

    public void mostrarCalle(){
        System.out.println("Calle : " + nombre);
        System.out.println("Distancia : " + distancia );

    }

}
