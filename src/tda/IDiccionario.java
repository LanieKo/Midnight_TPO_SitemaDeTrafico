package tda;

// Interfaz del TDA Diccionario
// Define el contrato para cualquier implementación de diccionario con clave String
public interface IDiccionario<V> {
    boolean insertar(String clave, V valor);
    V recuperarValor(String clave);
    boolean modificar(String clave, V valor);
    boolean eliminar(String clave);
    int existe(String clave);
    boolean estaVacio();
    int tamanio();
}
