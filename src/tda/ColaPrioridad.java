package tda;

// TDA Cola con Prioridad
// Mayor número = mayor prioridad. El arreglo queda ordenado de mayor a menor prioridad.
// El elemento de mayor prioridad queda en la posición 0 .
public class ColaPrioridad {


    public static class Elemento {
        public int dato;
        public int prioridad;
        public String descripcion;

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
