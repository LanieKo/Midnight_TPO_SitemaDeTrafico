package modelo;

// Emergencia: incidente que se gestiona con Cola de Prioridad
// Atributos: id, gravedad, ubicacion, hora (según UML propuesto)
// Método: asignarPrioridad()
public class Emergencia {

    private int id;
    private int gravedad;       // 1=leve ... 10=crítica (define prioridad en la cola)
    private String ubicacion;
    private String hora;
    private String descripcion;

    public Emergencia(int id, int gravedad, String ubicacion, String hora, String descripcion) {
        if (gravedad < 1 || gravedad > 10) {
            throw new IllegalArgumentException("La gravedad debe estar entre 1 y 10.");
        }
        this.id = id;
        this.gravedad = gravedad;
        this.ubicacion = ubicacion;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    // asignarPrioridad() según el UML propuesto
    // Retorna un nivel descriptivo según la gravedad
    public String asignarPrioridad() {
        if (gravedad >= 8)      return "CRÍTICA";
        else if (gravedad >= 5) return "MODERADA";
        else                    return "LEVE";
    }

    public int getId()          { return id; }
    public int getGravedad()    { return gravedad; }
    public String getUbicacion(){ return ubicacion; }
    public String getHora()     { return hora; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return "[ID=" + id
                + " | Gravedad=" + gravedad + " (" + asignarPrioridad() + ")"
                + " | " + descripcion
                + " | " + ubicacion
                + " | " + hora + "]";
    }
}
