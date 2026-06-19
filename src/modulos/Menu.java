package modulos;
import java.util.Scanner;

public class Menu {
    private Scanner teclado;
    int opcion;
    private ModeladoCiudad redVial;
    private DespachoEmergencias despacho;
    private GestorDispositivos gestor;
    private OrganizacionTerritorial territorio;
    private FlujoVehicular flujo;

    public Menu(ModeladoCiudad redVial, DespachoEmergencias despacho, GestorDispositivos gestor, OrganizacionTerritorial territorio, FlujoVehicular flujo) {
        this.opcion = -1;
        this.teclado = new Scanner(System.in);
        this.redVial = redVial;
        this.despacho = despacho;
        this.gestor = gestor;
        this.territorio = territorio;
        this.flujo = flujo;

    }

    public void iniciar() {
        // Display
        while (opcion != 0) {
            System.out.println("\n| -_ ˜”*°•MIDNIGHT•°*”˜ _- |");
            System.out.println("├─ (1). Modelado de ciudad");
            System.out.println("├─ (2). Emergencias");
            System.out.println("├─ (3). Dispositivos");
            System.out.println("├─ (4). Territorio");
            System.out.println("├─ (0). Salir");
            opcion = teclado.nextInt();

            // Muestra de Result    ados
            if (opcion == 1) {
                System.out.println("--->| Modelado de Ciudad |");
                redVial.mostrarRed();
                redVial.existeRuta("INT-01", "INT-04");
                System.out.println("\n--------------------------------------------------");
            } else if (opcion == 2) {
                System.out.println("--->| Emergencias |");
                despacho.mostrarTodasLasEmergencias();
                System.out.println("\n----------------------------------------------------------------");
            } else if (opcion == 3) {
                System.out.println("--->| Dispositivos |");
                gestor.mostrarTodos();
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
            } else if (opcion == 4) {
                territorio.mostrarEstructura();
                territorio.mostrarPorNiveles();
                System.out.println("\n-------------------------------------------------------------");
            } else if (opcion == 0) {
                System.out.println("\n------------------------------");
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida");
            }
        }
    }

}