package modelo;

// Cámara: hereda de Dispositivo (ver UML: Dispositivo → hereda en → Semáforo y Cámara)
// Atributos propios: resolucion
// Métodos propios: grabar()
public class Camara extends Dispositivo {

    private String resolucion;
    private boolean grabando;

    public Camara(String codigoUnico, String ubicacion, String resolucion) {
        super(codigoUnico, ubicacion);
        this.resolucion = resolucion;
        this.grabando = false;
    }

    // grabar() según el UML propuesto
    public void grabar() {
        if (estado == Estado.ACTIVO) {
            grabando = true;
            System.out.println("Cámara " + codigoUnico + " -> iniciando grabación a " + resolucion);
        } else {
            System.out.println("Cámara " + codigoUnico + " no puede grabar: estado " + estado);
        }
    }

    public void detenerGrabacion() {
        grabando = false;
        System.out.println("Cámara " + codigoUnico + " → grabación detenida.");
    }

}
