package tda;

// TDA Grafo con Matriz de Adyacencia PONDERADA

public class GrafoPonderado<T> implements IGrafoPonderado<T> {

    private T[] vertices;
    private int[][] matriz;    // matriz[i][j] = distancia, 0 = sin arista
    private int cantidad;
    private int capacidad;
    private boolean dirigido;

    @SuppressWarnings("unchecked")
    public GrafoPonderado(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.dirigido = dirigido;
        this.cantidad = 0;
        this.vertices = (T[]) new Object[capacidad];
        this.matriz = new int[capacidad][capacidad];
    }

    public void insertarVertice(T vertice) {
        if (cantidad == capacidad) {
            System.out.println("No se pueden insertar más vértices.");
            return;
        }
        if (existeVertice(vertice)) {
            System.out.println("El vértice ya existe: " + vertice);
            return;
        }
        vertices[cantidad] = vertice;
        cantidad++;
    }

    public boolean existeVertice(T vertice) {
        return obtenerIndice(vertice) != -1;
    }

    private int obtenerIndice(T vertice) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    // Inserta arista con peso
    public void insertarArista(T origen, T destino, int peso) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);
        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }
        matriz[posOrigen][posDestino] = peso;
        if (!dirigido) {
            matriz[posDestino][posOrigen] = peso;
        }
    }

    public void eliminarArista(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);
        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }
        matriz[posOrigen][posDestino] = 0;
        if (!dirigido) {
            matriz[posDestino][posOrigen] = 0;
        }
    }

    public boolean existeArista(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);
        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }
        return matriz[posOrigen][posDestino] != 0;
    }

    public void mostrarVertices() {
        System.out.print("Vértices: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia (pesos):");
        System.out.printf("%-10s", "");
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%8s", vertices[i]);
        }
        System.out.println();
        System.out.print("          ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("--------");
        }
        System.out.println();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-10s", vertices[i]);
            for (int j = 0; j < cantidad; j++) {
                if (matriz[i][j] == 0) {
                    System.out.printf("%8s", "-");
                } else {
                    System.out.printf("%8d", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }

    // BFS: determina si existe ruta entre dos puntos
    // Usa la Cola<T>
    public boolean existeRuta(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);
        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Vértice no encontrado.");
            return false;
        }

        boolean[] visitado = new boolean[capacidad];
        Cola<Integer> cola = new Cola<>();

        visitado[posOrigen] = true;
        cola.encolar(posOrigen);

        while (!cola.estaVacia()) {
            int actual = cola.desencolar();
            if (actual == posDestino) {
                return true;
            }
            for (int j = 0; j < cantidad; j++) {
                if (matriz[actual][j] != 0 && !visitado[j]) {
                    visitado[j] = true;
                    cola.encolar(j);
                }
            }
        }
        return false;
    }

    //  Dijkstra: ruta más corta (distancia mínima)
    // Algoritmo clásico con arreglos, sin importar librerías externas
    // Retorna el arreglo de distancias mínimas desde el origen
    public int[] dijkstra(T origen) {
        int posOrigen = obtenerIndice(origen);
        if (posOrigen == -1) {
            System.out.println("Vértice origen no encontrado.");
            return null;
        }

        int[] distancia = new int[cantidad];
        boolean[] procesado = new boolean[cantidad];

        // Inicializar distancias en "infinito"
        for (int i = 0; i < cantidad; i++) {
            distancia[i] = Integer.MAX_VALUE;
        }
        distancia[posOrigen] = 0;

        for (int iter = 0; iter < cantidad; iter++) {
            // Buscar el vértice no procesado con menor distancia
            int u = -1;
            for (int i = 0; i < cantidad; i++) {
                if (!procesado[i] && distancia[i] != Integer.MAX_VALUE) {
                    if (u == -1 || distancia[i] < distancia[u]) {
                        u = i;
                    }
                }
            }
            if (u == -1) break;
            procesado[u] = true;

            // Relajar aristas
            for (int v = 0; v < cantidad; v++) {
                if (matriz[u][v] != 0 && !procesado[v]) {
                    int nuevaDist = distancia[u] + matriz[u][v];
                    if (nuevaDist < distancia[v]) {
                        distancia[v] = nuevaDist;
                    }
                }
            }
        }
        return distancia;
    }

    // Muestra la ruta más corta desde origen a destino
    public void mostrarRutaMasCorta(T origen, T destino) {
        int[] distancias = dijkstra(origen);
        if (distancias == null) return;

        int posDestino = obtenerIndice(destino);
        if (posDestino == -1) {
            System.out.println("Vértice destino no encontrado.");
            return;
        }
        if (distancias[posDestino] == Integer.MAX_VALUE) {
            System.out.println("No existe ruta entre " + origen + " y " + destino + ".");
        } else {
            System.out.println("Ruta más corta de " + origen + " a " + destino
                    + ": " + distancias[posDestino] + " unidades.");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public T getVertice(int indice) {
        return vertices[indice];
    }
}
