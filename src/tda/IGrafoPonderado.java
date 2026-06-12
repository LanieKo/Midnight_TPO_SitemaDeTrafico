package tda;

// Interfaz del TDA Grafo Ponderado
// Define el contrato para grafos con pesos en las aristas
public interface IGrafoPonderado<T> {
    void insertarVertice(T vertice);
    void insertarArista(T origen, T destino, int peso);
    void eliminarArista(T origen, T destino);
    boolean existeVertice(T vertice);
    boolean existeArista(T origen, T destino);
    boolean existeRuta(T origen, T destino);
    int[] dijkstra(T origen);
}
