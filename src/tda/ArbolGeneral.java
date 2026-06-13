package tda;

// TDA Árbol General (N-ario)

public class ArbolGeneral<T> {

    // Nodo del árbol general: tiene dato y una lista de hijos
    public static class NodoGeneral<T> {
        public T dato;
        public NodoGeneral<T>[] hijos;
        public int cantHijos;
        public int maxHijos;

        @SuppressWarnings("unchecked")
        public NodoGeneral(T dato, int maxHijos) {
            this.dato = dato;
            this.maxHijos = maxHijos;
            this.hijos = new NodoGeneral[maxHijos];
            this.cantHijos = 0;
        }

        public boolean agregarHijo(NodoGeneral<T> hijo) {
            if (cantHijos == maxHijos) {
                System.out.println("Nodo lleno: no se pueden agregar más hijos a " + dato);
                return false;
            }
            hijos[cantHijos] = hijo;
            cantHijos++;
            return true;
        }

        @Override
        public String toString() {
            return dato.toString();
        }
    }

    private NodoGeneral<T> raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    // Crea la raíz del árbol (la ciudad)
    public void crearRaiz(T dato, int maxHijos) {
        raiz = new NodoGeneral<>(dato, maxHijos);
    }

    public NodoGeneral<T> getRaiz() {
        return raiz;
    }

    // Agrega un hijo a un nodo padre ya existente
    public boolean agregarHijo(NodoGeneral<T> padre, T datoHijo, int maxHijosDelHijo) {
        if (padre == null) {
            System.out.println("El nodo padre es nulo.");
            return false;
        }
        NodoGeneral<T> hijo = new NodoGeneral<>(datoHijo, maxHijosDelHijo);
        return padre.agregarHijo(hijo);
    }

    // Busca un nodo por su dato (recorrido DFS - Pre Orden)
    public NodoGeneral<T> buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private NodoGeneral<T> buscarRec(NodoGeneral<T> nodo, T dato) {
        if (nodo == null) return null;
        if (nodo.dato.equals(dato)) return nodo;
        for (int i = 0; i < nodo.cantHijos; i++) {
            NodoGeneral<T> resultado = buscarRec(nodo.hijos[i], dato);
            if (resultado != null) return resultado;
        }
        return null;
    }

    // Recorre e imprime el árbol con indentación (Pre Orden visual)
    public void mostrarArbol() {
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        mostrarRec(raiz, 0);
    }

    private void mostrarRec(NodoGeneral<T> nodo, int nivel) {
        if (nodo == null) return;
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
        System.out.println("├─ " + nodo.dato);
        for (int i = 0; i < nodo.cantHijos; i++) {
            mostrarRec(nodo.hijos[i], nivel + 1);
        }
    }

    // Recorre por niveles usando la Cola<T> de la materia
    public void mostrarPorNiveles() {
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        Cola<NodoGeneral<T>> cola = new Cola<>();
        cola.encolar(raiz);
        int nivel = 0;
        while (!cola.estaVacia()) {
            int cantNivel = cola.tamanio();
            System.out.print("Nivel " + nivel + ": ");
            for (int i = 0; i < cantNivel; i++) {
                NodoGeneral<T> actual = cola.desencolar();
                System.out.print(actual.dato + "  ");
                for (int j = 0; j < actual.cantHijos; j++) {
                    cola.encolar(actual.hijos[j]);
                }
            }
            System.out.println();
            nivel++;
        }
    }

    // Cuenta todos los nodos del árbol (recursivo)
    public int cantidadNodos() {
        return contarRec(raiz);
    }

    private int contarRec(NodoGeneral<T> nodo) {
        if (nodo == null) return 0;
        int total = 1;
        for (int i = 0; i < nodo.cantHijos; i++) {
            total += contarRec(nodo.hijos[i]);
        }
        return total;
    }
}
