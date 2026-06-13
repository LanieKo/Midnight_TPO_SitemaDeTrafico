package modelo;

// Interfaz para todo dispositivo urbano gestionable

public interface IGestionable {
    void modificarEstado(Dispositivo.Estado nuevoEstado);

    Dispositivo.Estado consultarEstado();

    String getCodigoUnico();
}
