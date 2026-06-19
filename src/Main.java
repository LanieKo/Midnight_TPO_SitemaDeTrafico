import modulos.*;
import modelo.*;

// TRABAJO PRÁCTICO OBLIGATORIO - Programación 2 - 2026
// "Midnight" - Sistema Inteligente de Tráfico y Emergencias

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu(
                redVial,
                despacho,
                gestorDispositivos,
                territorio,
                flujo1
        );

        menu.iniciar();




        System.out.println("=======================================================");
        System.out.println("   MIDNIGHT ⧬ - SISTEMA INTELIGENTE DE TRÁFICO");
        System.out.println("=======================================================\n");

        // MÓDULO 1: Red vial

        System.out.println(">>> MÓDULO 1: Modelado de la Ciudad <<<");
        ModeladoCiudad redVial = new ModeladoCiudad(8, false);

        // Crear objetos Interseccion y agregarlos al grafo
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

        // Crear objetos Calle y conectar intersecciones
        redVial.agregarCalle(new Calle("Av. Corrientes",   500), "INT-01", "INT-02");
        redVial.agregarCalle(new Calle("Av. 9 de Julio",   300), "INT-01", "INT-03");
        redVial.agregarCalle(new Calle("Calle Tucumán",    200), "INT-02", "INT-04");
        redVial.agregarCalle(new Calle("Av. Santa Fe",     400), "INT-03", "INT-04");
        redVial.agregarCalle(new Calle("Av. de Mayo",      150), "INT-04", "INT-05");
        redVial.agregarCalle(new Calle("Av. Rivadavia",    800), "INT-01", "INT-05");


        // BFS
        redVial.existeRuta("INT-01", "INT-04");
        //redVial.existeRuta("INT-02", "INT-05");

        // Dijkstra
        redVial.calcularRutaMasCorta("INT-01", "INT-04");
        //redVial.calcularRutaMasCorta("INT-01", "INT-05");

        System.out.println();

        // MÓDULO 2: Despacho de Emergencias

        System.out.println(">>> MÓDULO 2: Despacho de Emergencias <<<");
        DespachoEmergencias despacho = new DespachoEmergencias(10);

        // Reportar emergencias
        despacho.reportarEmergencia("Accidente leve en Av. Corrientes", 3,  "INT-01", "08:15");
        despacho.reportarEmergencia("Incendio en edificio",              9,  "INT-03", "08:20");
        despacho.reportarEmergencia("Choque múltiple en autopista",      7,  "INT-02", "08:22");
        despacho.reportarEmergencia("Corte de luz en semáforos",         4,  "INT-05", "08:25");
        despacho.reportarEmergencia("Heridos graves en colisión",        9,  "INT-04", "08:30");


        // Crear unidades de emergencia
        UnidadEmergencia ambulancia = new UnidadEmergencia("AMB-01", UnidadEmergencia.Tipo.AMBULANCIA);
        UnidadEmergencia bomberoU   = new UnidadEmergencia("BOM-01", UnidadEmergencia.Tipo.BOMBEROS);

        System.out.println("\nDespachando emergencias:");
        despacho.despacharSiguiente(ambulancia);   // gravedad 9
        despacho.despacharSiguiente(bomberoU);     // gravedad 9 (segunda con igual prioridad)
        despacho.despacharSiguiente();             // gravedad 7


        System.out.println();

        // MÓDULO 3: Gestor de Dispositivos

        System.out.println(">>> MÓDULO 3: Gestor de Dispositivos <<<");
        GestorDispositivos gestorDispositivos = new GestorDispositivos(20);

        // Registrar Semáforos
        gestorDispositivos.registrar(new Semaforo("SEM-001", "Av. Corrientes y 9 de Julio", 30));
        gestorDispositivos.registrar(new Semaforo("SEM-002", "Av. Santa Fe y Pueyrredón",   45));
        gestorDispositivos.registrar(new Semaforo("SEM-003", "Av. Cabildo y Juramento",     60));

        // Registrar Cámaras
        gestorDispositivos.registrar(new Camara("CAM-010", "Autopista 25 de Mayo km 3",    "1080p"));
        gestorDispositivos.registrar(new Camara("CAM-011", "Av. General Paz y Rivadavia",  "4K"));

        // Intento de código duplicado
        gestorDispositivos.registrar(new Semaforo("SEM-001", "Otro lugar", 20));


        // Consultar y modificar estado
        System.out.println("\nConsultando estado de SEM-002:");
        gestorDispositivos.consultarEstado("SEM-002");

        System.out.println("\nModificando estado de SEM-001 a FALLA:");
        gestorDispositivos.modificarEstado("SEM-001", Dispositivo.Estado.FALLA);

        // Cambiar luz de semáforo
        System.out.println("\nCambiando luz de SEM-002:");
        gestorDispositivos.cambiarLuzSemaforo("SEM-002");
        gestorDispositivos.cambiarLuzSemaforo("SEM-002");

        // Activar grabación de cámara
        System.out.println("\nActivando grabación de CAM-010:");
        gestorDispositivos.activarGrabacion("CAM-010");

        // Código inexistente
        System.out.println("\nBuscando dispositivo inexistente:");
        gestorDispositivos.obtener("SEM-999");

        System.out.println();

        // MÓDULO 4: Organización Territorial (Árbol General N-ario)

        System.out.println(">>> MÓDULO 4: Organización Territorial <<<");
        OrganizacionTerritorial territorio = new OrganizacionTerritorial();

        territorio.crearCiudad("Buenos Aires");

        // Agregar comunas (jerarquía propuesta: Ciudad → Comunas)
        territorio.agregarComuna("Comuna 1");
        territorio.agregarComuna("Comuna 2");
        territorio.agregarComuna("Comuna 13");

        // Agregar barrios a cada comuna
        territorio.agregarBarrio("Comuna 1",  "San Nicolás");
        territorio.agregarBarrio("Comuna 1",  "Montserrat");
        territorio.agregarBarrio("Comuna 2",  "Recoleta");
        territorio.agregarBarrio("Comuna 13", "Palermo");
        territorio.agregarBarrio("Comuna 13", "Belgrano");

        // Agregar manzanas a los barrios
        territorio.agregarManzana("San Nicolás", "A");
        territorio.agregarManzana("San Nicolás", "B");
        territorio.agregarManzana("Palermo",     "C");
        territorio.agregarManzana("Belgrano",    "D");

        // Mostrar estructura completa
        //territorio.mostrarEstructura();

        // Mostrar por niveles
        //territorio.mostrarPorNiveles();

        // Buscar territorios
        territorio.buscarTerritorio("Palermo");
        territorio.buscarTerritorio("Zona Inexistente");

        System.out.println("Total de territorios registrados: " + territorio.totalTerritorios());

        System.out.println();

        // MÓDULO 5: Flujo Vehicular

        System.out.println(">>> MÓDULO 5: Flujo Vehicular <<<");
        FlujoVehicular flujo1 = new FlujoVehicular(plazaCentral);   // INT-01
        FlujoVehicular flujo3 = new FlujoVehicular(comisaria);      // INT-03

        // Llegada de vehículos
        flujo1.llegadaVehiculo(new Vehiculo("AB123CD", Vehiculo.Tipo.AUTO));
        flujo1.llegadaVehiculo(new Vehiculo("EF456GH", Vehiculo.Tipo.CAMION));
        flujo1.llegadaVehiculo(new Vehiculo("IJ789KL", Vehiculo.Tipo.AUTO));
        flujo1.llegadaVehiculo(new Vehiculo("AMB-001", Vehiculo.Tipo.AMBULANCIA));

        flujo3.llegadaVehiculo(new Vehiculo("QR345ST", Vehiculo.Tipo.MOTO));
        flujo3.llegadaVehiculo(new Vehiculo("UV678WX", Vehiculo.Tipo.AUTO));

        flujo1.mostrarCola();
        flujo3.mostrarCola();

        // Ver próximo con destino indicado
        flujo1.verProximo("Av. Corrientes");

        // Liberar vehículos (FIFO)
        System.out.println("\nLiberando vehículos de Plaza Central (INT-01):");
        flujo1.liberarVehiculo();
        flujo1.liberarVehiculo();
        flujo1.mostrarCola();

        System.out.println("\nLiberando vehículos de Comisaría (INT-03):");
        flujo3.liberarVehiculo();
        flujo3.liberarVehiculo();
        // Intentar liberar de una cola vacía
        flujo3.liberarVehiculo();
        menu.iniciar();

    }
}
