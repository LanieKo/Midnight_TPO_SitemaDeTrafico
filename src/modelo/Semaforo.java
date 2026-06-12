package modelo;

// Semáforo: hereda de Dispositivo (ver UML: Dispositivo → hereda en → Semáforo y Cámara)
// Atributos propios: tiempoCambio
// Métodos propios: cambiarLuz()
public class Semaforo extends Dispositivo {

    public enum Luz { ROJO, AMARILLO, VERDE }

    private int tiempoCambio;   // segundos entre cambios de luz
    private Luz luzActual;

    public Semaforo(String codigoUnico, String ubicacion, int tiempoCambio) {
        super(codigoUnico, ubicacion);
        this.tiempoCambio = tiempoCambio;
        this.luzActual = Luz.ROJO;
    }

    // cambiarLuz() según el UML propuesto
    public void cambiarLuz() {
        switch (luzActual) {
            case ROJO:    luzActual = Luz.VERDE;   break;
            case VERDE:   luzActual = Luz.AMARILLO; break;
            case AMARILLO: luzActual = Luz.ROJO;   break;
        }
        System.out.println("Semáforo " + getCodigoUnico() + " → luz cambiada a: " + luzActual);
    }

    public Luz getLuzActual()    { return luzActual; }
    public int getTiempoCambio() { return tiempoCambio; }

    @Override
    public String toString() {
        return "SEMAFORO | " + super.toString()
                + " | Luz: " + luzActual
                + " | TiempoCambio: " + tiempoCambio + "s";
    }
}
