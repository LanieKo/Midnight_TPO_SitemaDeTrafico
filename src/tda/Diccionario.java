package tda;

// TDA Diccionario con clave String
public class Diccionario<V> implements IDiccionario<V> {
    // Clase interna Dato, equivalente a la de diccionarios/Dato.java
    private class Dato {
        String clave;
        V valor;

        Dato(String clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Object[] datosDiccionario;
    private int cantidad;
    private int dimension;

    @SuppressWarnings("unchecked")
    public Diccionario(int dimension) {
        this.dimension = dimension;
        this.datosDiccionario = new Object[dimension];
        this.cantidad = 0;
    }

    public boolean estaVacio() {
        return cantidad == 0;
    }

    // Retorna la posición si existe la clave, -1 si no (igual que en clase)
    public int existe(String clave) {
        if (estaVacio()) {
            return -1;
        }
        for (int i = 0; i < cantidad; i++) {
            if (((Dato) datosDiccionario[i]).clave.equals(clave)) {
                return i;
            }
        }
        return -1;
    }

    // Inserta clave-valor. No permite duplicados
    public boolean insertar(String clave, V valor) {
        if (cantidad == dimension) {
            System.out.println("Diccionario lleno: clave no agregada.");
            return false;
        }
        if (existe(clave) == -1) {
            datosDiccionario[cantidad] = new Dato(clave, valor);
            cantidad++;
            return true;
        }
        System.out.println("Clave existente --> no agregada: " + clave);
        return false;
    }

    // Recupera el valor por clave (O(n) en el peor caso
    public V recuperarValor(String clave) {
        int posicion = existe(clave);
        if (posicion != -1) {
            return ((Dato) datosDiccionario[posicion]).valor;
        }
        System.out.println("No existe la clave: " + clave);
        return null;
    }

    // Modifica el valor de una clave existente
    public boolean modificar(String clave, V valor) {
        int posicion = existe(clave);
        if (posicion != -1) {
            ((Dato) datosDiccionario[posicion]).valor = valor;
            return true;
        }
        System.out.println("No existe la clave a modificar: " + clave);
        return false;
    }

    // Elimina por clave corriendo elementos
    public boolean eliminar(String clave) {
        int posicion = existe(clave);
        if (posicion == -1) {
            System.out.println("Clave no eliminada --> no existe: " + clave);
            return false;
        }
        for (int i = posicion; i < cantidad - 1; i++) {
            datosDiccionario[i] = datosDiccionario[i + 1];
        }
        datosDiccionario[cantidad - 1] = null;
        cantidad--;
        return true;
    }

    public int tamanio() {
        return cantidad;
    }

    public void mostrar() {
        if (!estaVacio()) {
            System.out.println("Diccionario:");
            for (int i = 0; i < cantidad; i++) {
                System.out.println("  " +  ((Dato) datosDiccionario[i]).clave + " --> " + ((Dato) datosDiccionario[i]).valor);
            }
        } else {
            System.out.println("No existen elementos en el diccionario.");
        }
    }

    public void listarClaves() {
        System.out.print("Claves: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(((Dato) datosDiccionario[i]).clave + " - ");
        }
        System.out.println();
    }
}
