package modulos;
import modelo.Interseccion;
import modelo.*;

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
            System.out.println("\n========== ORGANIZACIÓN TERRITORIAL ==========");
            System.out.println("├─ (1). Agregar Comuna");
            System.out.println("├─ (2). Agregar Barrio");
            System.out.println("├─ (3). Agregar Manzana");
            System.out.println("├─ (4). Buscar Territorio");
            System.out.println("├─ (5). Mostrar Estructura Territorial");

            System.out.println("\n========== MODELADO DE CIUDAD ==========");
            System.out.println("├─ (6). Agregar Intersección");
            System.out.println("├─ (7). Agregar Calle");
            System.out.println("├─ (8). Mostrar Red Vial");
            System.out.println("├─ (9). Verificar Ruta");
            System.out.println("├─ (10). Calcular Ruta Más Corta");

            System.out.println("\n========== EMERGENCIAS ==========");
            System.out.println("├─ (11). Reportar Emergencia");
            System.out.println("├─ (12). Despachar Emergencia");
            System.out.println("├─ (13). Mostrar Emergencias");

            System.out.println("\n========== DISPOSITIVOS ==========");
            System.out.println("├─ (14). Registrar Dispositivo");
            System.out.println("├─ (15). Mostrar Dispositivos");
            System.out.println("├─ (16). Buscar Dispositivo");
            System.out.println("├─ (17). Consultar Estado Dispositivo");
            System.out.println("├─ (18). Modificar Estado Dispositivo");
            System.out.println("├─ (19). Cambiar Luz de Semáforo");
            System.out.println("├─ (0). Salir");

            System.out.print("\nSeleccione una opción: ");
            opcion = teclado.nextInt();

            // Muestra de Result    ados
            if (opcion == 1) {
                teclado.nextLine();
                System.out.print("Nombre comuna: ");
                String comuna = teclado.nextLine();
                territorio.agregarComuna(comuna);
                System.out.println("\n--------------------------------------------------");

            } else if (opcion == 2) {
                teclado.nextLine();
                System.out.print("Comuna: ");
                String comuna = teclado.nextLine();
                System.out.print("Barrio: ");
                String barrio = teclado.nextLine();
                territorio.agregarBarrio(comuna, barrio);
                System.out.println("\n----------------------------------------------------------------");

            } else if (opcion == 3) {
                teclado.nextLine();
                System.out.print("Barrio: ");
                String barrio = teclado.nextLine();
                System.out.print("Manzana: ");
                String manzana = teclado.nextLine();
                territorio.agregarManzana(barrio, manzana);
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");

            } else if (opcion == 4) {
                teclado.nextLine();
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                territorio.buscarTerritorio(nombre);


                System.out.println("\n-------------------------------------------------------------");

            } else if (opcion == 5) {
                territorio.mostrarEstructura();



                System.out.println("\n------------------------------");

            } else if (opcion == 6) {
                System.out.print("ID: ");
                String id = teclado.next();
                teclado.nextLine();
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                redVial.agregarInterseccion(new Interseccion(id, nombre));


                System.out.println("\n------------------------------");

            } else if (opcion== 7) {
                teclado.nextLine();
                System.out.print("Nombre calle: ");
                String nombre = teclado.nextLine();
                System.out.print("Distancia: ");
                int distancia = teclado.nextInt();
                System.out.print("ID origen: ");
                String origen = teclado.next();
                System.out.print("ID destino: ");
                String destino = teclado.next();
                redVial.agregarCalle(new Calle(nombre, distancia), origen, destino);



            }else if (opcion == 8){
                redVial.mostrarRed();



            }else if (opcion == 9) {
                System.out.print("Origen: ");
                String origen = teclado.next();
                System.out.print("Destino: ");
                String destino = teclado.next();
                redVial.existeRuta(origen, destino);



            }else if (opcion == 10) {
                System.out.print("Origen: ");
                String origen = teclado.next();
                System.out.print("Destino: ");
                String destino = teclado.next();
                redVial.calcularRutaMasCorta(origen, destino);



            }else if (opcion == 11) {
                teclado.nextLine();
                System.out.print("Descripción: ");
                String descripcion = teclado.nextLine();
                System.out.print("Gravedad: ");
                int gravedad = teclado.nextInt();
                System.out.print("Ubicación: ");
                String ubicacion = teclado.next();
                System.out.print("Hora: ");
                String hora = teclado.next();
                despacho.reportarEmergencia(
                        descripcion,
                        gravedad,
                        ubicacion,
                        hora
                );



            }else if (opcion == 12) {
                despacho.despacharSiguiente();



            }else if (opcion == 13) {
                despacho.mostrarTodasLasEmergencias();



            }else if (opcion == 14) {
                System.out.println("1. Semáforo");
                System.out.println("2. Cámara");
                int tipo = teclado.nextInt();
                if(tipo == 1){

                    System.out.print("Código: ");
                    String codigo = teclado.next();
                    teclado.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = teclado.nextLine();
                    System.out.print("Tiempo ciclo: ");
                    int tiempo = teclado.nextInt();
                    gestor.registrar( new Semaforo(codigo, ubicacion, tiempo));

                } else if(tipo == 2){

                    System.out.print("Código: ");
                    String codigo = teclado.next();
                    teclado.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = teclado.nextLine();
                    System.out.print("Resolución: ");
                    String resolucion = teclado.nextLine();
                    gestor.registrar(new Camara(codigo, ubicacion, resolucion));
                }


            }else if (opcion == 15) {
                gestor.mostrarTodos();

            }else if (opcion == 16) {
                System.out.print("Código: ");
                String codigo = teclado.next();
                gestor.obtener(codigo);



            }else if (opcion == 17) {
                System.out.print("Código: ");
                String codigo = teclado.next();
                gestor.consultarEstado(codigo);


            }else if (opcion == 18) {
                System.out.print("Código: ");
                String codigo = teclado.next();
                gestor.modificarEstado( codigo,Dispositivo.Estado.FALLA);



            }else if (opcion == 19) {
                System.out.print("Código semáforo: ");
                String codigo = teclado.next();
                gestor.cambiarLuzSemaforo(codigo);

            }else if (opcion == 0) {

                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida");
            }
        }
    }

}