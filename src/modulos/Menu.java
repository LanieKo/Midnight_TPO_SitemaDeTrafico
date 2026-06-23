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
            System.out.println("├─ (9). Calcular Ruta Más Corta");

            System.out.println("\n========== EMERGENCIAS ==========");
            System.out.println("├─ (10). Reportar Emergencia");
            System.out.println("├─ (11). Despachar Emergencia");
            System.out.println("├─ (12). Mostrar Emergencias");

            System.out.println("\n========== DISPOSITIVOS ==========");
            System.out.println("├─ (13). Registrar Dispositivo");
            System.out.println("├─ (14). Mostrar Dispositivos");
            System.out.println("├─ (15). Buscar Dispositivo");
            System.out.println("├─ (16). Consultar Estado Dispositivo");
            System.out.println("├─ (17). Modificar Estado Dispositivo");
            System.out.println("├─ (18). Cambiar Luz de Semáforo");
            System.out.println("├─ (0). Salir");

            System.out.print("\nSeleccione una opción: ");
            opcion = teclado.nextInt();

            // Opciones
            if (opcion == 1) {
                teclado.nextLine();
                System.out.print("Nombre comuna: ");
                String comunaInput = teclado.nextLine();

                if (comunaInput.equals("")) {
                    System.out.println("Error: El campo no puede estar vacío.");
                } else {
                    territorio.agregarComuna(comunaInput);
                    System.out.println("¡Comuna agregada con éxito!");
                }
                System.out.println("\n--------------------------------------------------");
            }

            else if (opcion == 2) {
                teclado.nextLine();
                System.out.print("Comuna: ");
                String comuna = teclado.nextLine();

                System.out.print("Barrio: ");
                String barrio = teclado.nextLine();

                if (territorio.existeTerritorio(barrio)) {

                    System.out.println("Error: El barrio ya existe.");

                } else if (territorio.agregarBarrio(comuna, barrio) != null) {

                    System.out.println("¡El barrio fue agregado correctamente bajo la comuna indicada!");
                }
                System.out.println("\n----------------------------------------------------------------");
            }

            else if (opcion == 3) {
            teclado.nextLine();
            System.out.print("Barrio: ");
            String barrio = teclado.nextLine();
            System.out.print("Manzana: ");
            String manzana = teclado.nextLine();
            territorio.agregarManzana(barrio, manzana);
        }

            else if (opcion == 4) {
                teclado.nextLine();
                System.out.print("Nombre del territorio a buscar: ");
                String nombre = teclado.nextLine();
                System.out.println("\n--- Iniciando Búsqueda Territorial ---");
                territorio.buscarTerritorio(nombre);
                System.out.println("\n-------------------------------------------------------------");
            }

            else if (opcion == 5) {
                territorio.mostrarEstructura();
                System.out.println("\n------------------------------");

            }

            else if (opcion == 6) {
                System.out.print("ID: ");
                String id = teclado.next();
                teclado.nextLine();
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                redVial.agregarInterseccion(new Interseccion(id, nombre));
                System.out.println("\n------------------------------");

            }

            else if (opcion == 7) {
                teclado.nextLine();

                System.out.println("\n--- Intersecciones Disponibles ---");
                redVial.mostrarRed();
                System.out.print("Nombre calle: ");
                String nombre = teclado.nextLine();
                System.out.print("Distancia: ");
                int distancia = teclado.nextInt();
                if (distancia <= 0) {
                    System.out.println("Error: La distancia debe ser positiva.");
                } else {
                    System.out.print("ID origen: ");
                    String origen = teclado.next();
                    System.out.print("ID destino: ");
                    String destino = teclado.next();
                    if (redVial.buscarInterseccion(origen) == null) {
                        System.out.println("Error: El ID de origen no existe.");
                    } else if (redVial.buscarInterseccion(destino) == null) {
                        System.out.println("Error: El ID de destino no existe.");
                    } else {
                        redVial.agregarCalle(
                                new Calle(nombre, distancia),
                                origen,
                                destino
                        );

                        System.out.println("¡Calle agregada correctamente!");
                    }
            }
            }
            else if (opcion == 8) {
                redVial.mostrarRed();
            }

            else if (opcion == 9) {
                System.out.print("Origen: ");
                String origen = teclado.next();
                System.out.print("Destino: ");
                String destino = teclado.next();

                if (redVial.existeRuta(origen, destino)) {
                    System.out.println("Calculando la ruta más corta...");
                    redVial.calcularRutaMasCorta(origen, destino);
                } else {
                    System.out.println("Error: No existe una ruta válida entre el origen y el destino ingresados.");
                }
            }

            else if (opcion == 10) {
                teclado.nextLine();

                System.out.print("Descripción: ");
                String descripcion = teclado.nextLine();

                System.out.print("Gravedad: ");
                int gravedad = teclado.nextInt();

                if (gravedad < 0) {

                    System.out.println("Error: La gravedad no puede ser negativa.");

                } else {

                    System.out.print("Ubicación (ID Intersección): ");
                    String ubicacion = teclado.next();
                    System.out.print("Hora: ");
                    String hora = teclado.next();

                    if (hora.length() != 5) {

                        System.out.println("Error: La hora debe tener el formato HH:MM.");

                    } else
                        despacho.reportarEmergencia(
                            descripcion,
                            gravedad,
                            ubicacion,
                            hora ); }

                    System.out.println("¡Emergencia reportada correctamente!");
                }

            else if (opcion == 11) {
                despacho.despacharSiguiente();

            }

            else if (opcion == 12) {
                despacho.mostrarTodasLasEmergencias();
            }

            else if (opcion == 13) {
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

                        if (tiempo <= 0) {
                            System.out.println("Error: El tiempo de ciclo tiene que ser positivo.");
                        } else {
                            gestor.registrar(new Semaforo(codigo, ubicacion, tiempo));
                            System.out.println("¡Semáforo registrado!");
                        }
                    }
                if (tipo == 2) {
                    System.out.print("Código: ");
                    String codigo = teclado.next();
                    teclado.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = teclado.nextLine();
                    System.out.print("Resolución: ");
                    String resolucion = teclado.nextLine();
                    gestor.registrar(new Camara(codigo, ubicacion, resolucion));
                    System.out.println("¡Cámara registrada!");

                }
            }

            else if (opcion == 14) {
                gestor.mostrarTodos();

            }

            else if (opcion == 15) {
                System.out.print("Código: ");
                String codigo = teclado.next();
                gestor.obtener(codigo);



            }

            else if (opcion == 16) {
                System.out.print("Código: ");
                String codigo = teclado.next();
                gestor.consultarEstado(codigo);


            }

            else if (opcion == 17) {
                System.out.print("Código: ");
                String codigo = teclado.next();

                Dispositivo dispositivo = gestor.obtener(codigo);

                if (dispositivo != null) {

                    if (dispositivo.getEstado() == Dispositivo.Estado.ACTIVO) {

                        gestor.modificarEstado(codigo, Dispositivo.Estado.FALLA);
                        System.out.println("Estado cambiado a FALLA.");

                    } else {

                        gestor.modificarEstado(codigo, Dispositivo.Estado.ACTIVO);
                        System.out.println("Estado cambiado a ACTIVO.");
                    }
                }

            }

            else if (opcion == 18) {
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