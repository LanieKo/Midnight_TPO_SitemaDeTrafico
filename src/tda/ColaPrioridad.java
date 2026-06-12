package tda;

// TDA Cola con Prioridad - basado en el PDF claseAbril10_ColaCircularyConPrioridad.pdf
// Mayor número = mayor prioridad. El arreglo queda ordenado de mayor a menor prioridad.
// El elemento de mayor prioridad queda en la posición 0 (igual que en clase).
public class ColaPrioridad {

    // Clase interna Elemento, idéntica a la vista en el PDF de la materia
    public static class Elemento {
        public int dato;
        public int prioridad;
        public String descripcion; // campo extra para el dominio del TPO

        public Elemento(int dato, int prioridad, String descripcion) {
            this.dato = dato;
            this.prioridad = prioridad;
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return "[ID=" + dato + " | Prioridad=" + prioridad + " | " + descripcion + "]";
        }
    }

    private Elemento[] cola;
    private int cantidad;
    private int max;

    public ColaPrioridad(int max) {
        this.max = max;
        this.cola = new Elemento[max];
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == max;
    }

    // Inserción ordenada: mantiene el arreglo de mayor a menor prioridad
    // Algoritmo pseudocódigo del PDF:
    //   i ← cantidad - 1
    //   mientras i >= 0 y cola[i].prioridad < prioridad hacer
    //     cola[i+1] ← cola[i]   (desplazar)
    //     i ← i - 1
    //   cola[i+1] ← nuevo
    public boolean insertar(int dato, int prioridad, String descripcion) {
        if (estaLlena()) {
            System.out.println("Cola con prioridad llena: no se puede insertar.");
            return false;
        }
        Elemento nuevo = new Elemento(dato, prioridad, descripcion);
        int i = cantidad - 1;
        while (i >= 0 && cola[i].prioridad < prioridad) {
            cola[i + 1] = cola[i];
            i--;
        }
        cola[i + 1] = nuevo;
        cantidad++;
        return true;
    }

    // Elimina y retorna el elemento de mayor prioridad (posición 0)
    // Algoritmo del PDF:
    //   eliminado ← cola[0]
    //   para i desde 0 hasta cantidad-2: cola[i] ← cola[i+1]
    //   cantidad ← cantidad - 1
    public Elemento eliminar() {
        if (estaVacia()) {
            System.out.println("Cola con prioridad vacía: no se puede eliminar.");
            return null;
        }
        Elemento eliminado = cola[0];
        for (int i = 0; i < cantidad - 1; i++) {
            cola[i] = cola[i + 1];
        }
        cantidad--;
        return eliminado;
    }

    // Devuelve el frente sin eliminarlo
    public Elemento frente() {
        if (estaVacia()) {
            return null;
        }
        return cola[0];
    }

    public int tamanio() {
        return cantidad;
    }

    public void mostrar() {
        System.out.println("Cola con Prioridad (mayor a menor):");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("  Pos " + i + ": " + cola[i]);
        }
    }
}
