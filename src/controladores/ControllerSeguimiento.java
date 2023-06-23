package controladores;

import java.util.ArrayList;

import enums.Calificacion;
import modelos.Seguimiento;
import modelos.Adopcion;
import color.ConsoleColors;

public class ControllerSeguimiento {
    
    private static ControllerSeguimiento instancia;
    // atributos
    private ArrayList<Seguimiento> seguimientos;

    // constructor
    private ControllerSeguimiento() {
        seguimientos = new ArrayList<Seguimiento>();
    }

    public static ControllerSeguimiento getInstancia() {
        if (instancia == null)
            instancia = new ControllerSeguimiento();
        return instancia;
    }

    // metodos

    private Seguimiento buscarSeguimiento(int numeroSeguimiento) {
        Seguimiento seguimientoEncontrado = null;
        for (Seguimiento s : seguimientos) {
            if (s.getNumeroSeguimiento() == numeroSeguimiento) {
                seguimientoEncontrado = s;
            }
        }
        return seguimientoEncontrado;
    }

    public int agregarSeguimientoAnimal(int numeroAdopcion) {
        Adopcion adopcion = ControllerAdopcion.getInstancia().buscarAdopcion(numeroAdopcion);
        Seguimiento seguimiento = adopcion.getSeguimiento();
        this.seguimientos.add(seguimiento);
        return seguimiento.getNumeroSeguimiento();
    }

    public void agregarVisita(int numeroSeguimiento, String comentario, Calificacion estadoAnimal,
            Calificacion limpieza, Calificacion ambiente) {
        Seguimiento seguimiento = buscarSeguimiento(numeroSeguimiento);
        seguimiento.agregarVisita(comentario, estadoAnimal, limpieza, ambiente);
    }

    public void finalizarSeguimiento(int numeroSeguimiento){
        Seguimiento seguimiento = this.buscarSeguimiento(numeroSeguimiento);
        if(seguimiento instanceof Seguimiento){
            seguimiento.setContinuarSeguimiento(false);
            System.out.println(ConsoleColors.GREEN + "El seguimiento fue finalizado correctamente!" + ConsoleColors.RESET);
        }
        else{
            System.out.println(ConsoleColors.RED + "No se pudo hallar el seguimiento solicitado" + ConsoleColors.RESET);
        }
    }
}
