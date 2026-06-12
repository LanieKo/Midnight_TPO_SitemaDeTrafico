package tda;

// Interfaz del TDA Cola
// Define el contrato que debe cumplir cualquier implementación de Cola
public interface ICola<T> {
    void encolar(T dato);
    T desencolar();
    T recuperarFrente();
    boolean estaVacia();
    int tamanio();
}
