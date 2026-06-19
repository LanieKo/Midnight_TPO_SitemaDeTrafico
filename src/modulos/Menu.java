package modulos;
import modelo.Interseccion;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Scanner teclado;
    int opcion;
    private ModeladoCiudad redVial;
    private DespachoEmergencias despacho;
    private GestorDispositivos gestor;
    private OrganizacionTerritorial territorio;
    private ArrayList<FlujoVehicular> flujos;

    public Menu(ModeladoCiudad redVial, DespachoEmergencias despacho, GestorDispositivos gestor, OrganizacionTerritorial territorio) {
        this.opcion = -1;
        this.teclado = new Scanner(System.in);
        this.redVial = redVial;
        this.despacho = despacho;
        this.gestor = gestor;
        this.territorio = territorio;
        this.flujos = flujos;

    }

    private FlujoVehicular buscarFlujos(String codigo) {
        for (FlujoVehicular flujos : flujos) {
            if (flujos.getInterseccion().getId().equals(codigo)) {
                return flujos;
            }
        }
        return null;
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

            System.out.println("\n=== MIDNIGHT ===");
            System.out.println("1. Modelado de ciudad");
            System.out.println("2. Emergencias");
            System.out.println("3. Dispositivos");
            System.out.println("4. Territorio");
            System.out.println("5. Mostrar Cola");
            System.out.println("6. Liberar Vehiculo");
            System.out.println("7. Liberar Vehiculo");

            System.out.println("0. Salir");
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

            } else if (opcion == 5) {

                Interseccion plazaCentral   = new Interseccion("INT-01", "Plaza Central");
                Interseccion hospital       = new Interseccion("INT-02", "Hospital Público");
                Interseccion comisaria      = new Interseccion("INT-03", "Comisaría");
                Interseccion bomberos       = new Interseccion("INT-04", "Estación de Bomberos");
                Interseccion municipalidad  = new Interseccion("INT-05", "Municipalidad");

                redVial.agregarInterseccion(plazaCentral);
                redVial.agregarInterseccion(hospital);
                redVial.agregarInterseccion(comisaria);
                redVial.agregarInterseccion(bomberos);
                redVial.agregarInterseccion(municipalidad);
                System.out.println("Mostrar Cola");
                System.out.println("Ingrese el código de la intersección:");
                String codigo = teclado.next();

                FlujoVehicular flujo = buscarFlujos(codigo);

                if (flujo != null) {
                    flujo.mostrarCola();
                }

                flujo.verProximo("Av. Corrientes");
            } else if (opcion== 6) {
                //flujo.liberarVehiculo();

            }else if (opcion == 7){


            }else if (opcion == 0) {

                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida");
            }
        }
    }

}