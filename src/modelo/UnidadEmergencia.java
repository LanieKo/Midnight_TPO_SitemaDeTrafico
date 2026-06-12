package modelo;

// UnidadEmergencia: puede ser asignada a atender una Emergencia
// Atributos: codigo, estado (según UML propuesto)
// Método: atenderEmergencia()
public class UnidadEmergencia {

    public enum Estado { DISPONIBLE, EN_CAMINO, ATENDIENDO, FUERA_DE_SERVICIO }
    public enum Tipo   { AMBULANCIA, BOMBEROS, POLICIA }

    private String codigo;
    private Estado estado;
    private Tipo tipo;

    public UnidadEmergencia(String codigo, Tipo tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = Estado.DISPONIBLE;
    }

    // atenderEmergencia() según el UML propuesto
    public void atenderEmergencia(Emergencia emergencia) {
        if (estado != Estado.DISPONIBLE) {
            System.out.println("Unidad " + codigo + " no disponible (estado: " + estado + ").");
            return;
        }
        estado = Estado.ATENDIENDO;
        System.out.println("Unidad " + codigo + " [" + tipo + "] → atendiendo: " + emergencia);
    }

    public void liberarUnidad() {
        estado = Estado.DISPONIBLE;
        System.out.println("Unidad " + codigo + " → libre y disponible.");
    }

    public String getCodigo() { return codigo; }
    public Estado getEstado() { return estado; }
    public Tipo getTipo()     { return tipo; }

    @Override
    public String toString() {
        return codigo + " [" + tipo + "] | Estado: " + estado;
    }
}
