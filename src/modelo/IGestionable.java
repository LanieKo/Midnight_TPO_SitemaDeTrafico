package modelo;

// Interfaz para todo dispositivo urbano gestionable
// Formaliza el contrato de modificarEstado() y consultarEstado() del UML
public interface IGestionable {
    void modificarEstado(Dispositivo.Estado nuevoEstado);
    Dispositivo.Estado consultarEstado();
    String getCodigoUnico();
}
