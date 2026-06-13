package modelo;

// Clase base para dispositivos urbanos (semáforos y cámaras)

public abstract class Dispositivo implements IGestionable {

    public enum Estado { ACTIVO, INACTIVO, FALLA }

    protected String codigoUnico;   // clave en el Diccionario
    protected Estado estado;
    protected String ubicacion;

    public Dispositivo(String codigoUnico, String ubicacion) {
        if (codigoUnico == null || codigoUnico.isEmpty()) {
            throw new IllegalArgumentException("El código del dispositivo no puede estar vacío.");
        }
        this.codigoUnico = codigoUnico;
        this.ubicacion = ubicacion;
        this.estado = Estado.ACTIVO;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }
    public Estado getEstado()      {
        return estado;
    }
    public String getUbicacion()   {
        return ubicacion;
    }

    public void modificarEstado(Estado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Estado consultarEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Código: " + codigoUnico + " | Ubicación: " + ubicacion + " | Estado: " + estado;
    }
}
