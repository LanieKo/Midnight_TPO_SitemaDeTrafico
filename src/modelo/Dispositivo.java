package modelo;

// Clase base para dispositivos urbanos (semáforos y cámaras)
// Identificado por codigoUnico → se indexa en el Diccionario del sistema
// Semáforo y Cámara heredan de esta clase (ver UML: Dispositivo → hereda en → Semáforo y Cámara)
public abstract class Dispositivo implements IGestionable {

    public enum Estado { ACTIVO, INACTIVO, FALLA }

    private String codigoUnico;   // clave en el Diccionario
    private Estado estado;
    private String ubicacion;

    public Dispositivo(String codigoUnico, String ubicacion) {
        if (codigoUnico == null || codigoUnico.isEmpty()) {
            System.out.println("El código del dispositivo no puede estar vacío.");
        }
        this.codigoUnico = codigoUnico;
        this.ubicacion = ubicacion;
        this.estado = Estado.ACTIVO;
    }

    public String getCodigoUnico() { return codigoUnico; }
    public Estado getEstado()      { return estado; }
    public String getUbicacion()   { return ubicacion; }

    // modificarEstado() y consultarEstado() según el UML propuesto
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
