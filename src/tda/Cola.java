package tda;

// TDA Cola con nodos enlazados - basado en Cola.java visto en clase (Arbol/Cola.java)
public class Cola<T> implements ICola<T> {

    private class NodoCola {
        T dato;
        NodoCola siguiente;

        NodoCola(T dato) {
            this.dato = dato;
        }
    }

    private NodoCola frente;
    private NodoCola fin;
    private int tamanio;

    public Cola() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    // Encola un elemento al final - O(1)
    public void encolar(T dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (fin == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamanio++;
    }

    // Desencola el elemento del frente - O(1)
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Cola vacía: no se puede desencolar.");
            return null;
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return dato;
    }

    // Retorna el frente sin eliminarlo - O(1)
    public T recuperarFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamanio() {
        return tamanio;
    }

    public void mostrar() {
        NodoCola actual = frente;
        System.out.print("Cola [frente -> fin]: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
