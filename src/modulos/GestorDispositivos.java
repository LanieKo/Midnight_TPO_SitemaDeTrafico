package modulos;

import tda.Diccionario;
import modelo.Dispositivo;
import modelo.Semaforo;
import modelo.Camara;

// MÓDULO 3 - Gestor de Dispositivos (semáforos y cámaras)

// Admite Semaforo y Camara (ambos heredan de Dispositivo)
// Permite recuperar o modificar el estado de un dispositivo por su código único
public class GestorDispositivos {

    private Diccionario<Dispositivo> indiceDispositivos;

    public GestorDispositivos(int capacidadMaxima) {
        indiceDispositivos = new Diccionario<>(capacidadMaxima);
    }

    // Registra un Semáforo o Cámara (ambos son Dispositivo)
    public void registrar(Dispositivo dispositivo) {
        boolean insertado = indiceDispositivos.insertar(dispositivo.getCodigoUnico(), dispositivo);
        if (insertado) {
            //System.out.println("Dispositivo registrado: " + dispositivo.getCodigoUnico());
        }
    }

    // Recupera un dispositivo por su codigoUnico - usa Diccionario.recuperarValor()
    public Dispositivo obtener(String codigoUnico) {
        Dispositivo d = indiceDispositivos.recuperarValor(codigoUnico);
        if (d == null) {
            System.out.println("Dispositivo no encontrado: " + codigoUnico);
        }else {
            System.out.println(d);
        }
        return d;
    }

    // Modifica el estado usando modificarEstado() del modelo Dispositivo
    public void modificarEstado(String codigoUnico, Dispositivo.Estado nuevoEstado) {
        Dispositivo d = obtener(codigoUnico);
        if (d != null) {
            d.modificarEstado(nuevoEstado);
            indiceDispositivos.modificar(codigoUnico, d);
            System.out.println("Estado actualizado -> " + d);
        }
    }

    // consultarEstado() del modelo Dispositivo
    public void consultarEstado(String codigoUnico) {
        Dispositivo d = obtener(codigoUnico);
        if (d != null) {
            System.out.println("Estado de " + codigoUnico + ": " + d.consultarEstado());
        }
    }

    // Acceso tipado a Semaforo para invocar cambiarLuz()
    public void cambiarLuzSemaforo(String codigoUnico) {
        Dispositivo d = obtener(codigoUnico);
        if (d instanceof Semaforo) {
            ((Semaforo) d).cambiarLuz();
        } else if (d != null) {
            System.out.println("El dispositivo " + codigoUnico + " no es un semáforo.");
        }
    }

    // Acceso tipado a Camara para invocar grabar()
    public void activarGrabacion(String codigoUnico) {
        Dispositivo d = obtener(codigoUnico);
        if (d instanceof Camara) {
            ((Camara) d).grabar();
        } else if (d != null) {
            System.out.println("El dispositivo " + codigoUnico + " no es una cámara.");
        }
    }

    public boolean existe(String codigoUnico) {
        return indiceDispositivos.existe(codigoUnico) != -1;
    }

    public int totalRegistrados() {
        return indiceDispositivos.tamanio();
    }

    public void mostrarTodos() {
        System.out.println("\n--- Inventario de Dispositivos ---");
        indiceDispositivos.mostrar();
        System.out.println("Total: " + indiceDispositivos.tamanio() + " dispositivos.");
    }
}
