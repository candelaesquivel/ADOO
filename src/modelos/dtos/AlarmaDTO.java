package modelos.dtos;

import java.util.ArrayList;
import java.util.Date;

import estrategias.accion.ITipoAlarma;
import modelos.Animal;
import color.ConsoleColors;
import java.time.Duration;

public class AlarmaDTO {

    private int numeroAlarma;
    private Duration periodicidad;
    private Animal animal;
    private ITipoAlarma tipoAlarma;
    private UsuarioDTO usuarioDTO;
    private Date ultimaEjecucion;
    private String comentario;

    public AlarmaDTO(int numeroAlarma, Duration periodicidad, Animal animal,
            ITipoAlarma tipoAlarma, UsuarioDTO usuarioDTO, Date ultimaEjecucion2, String comentario) {
        this.numeroAlarma = numeroAlarma;
        this.periodicidad = periodicidad;
        this.animal = animal;
        this.tipoAlarma = tipoAlarma;
        this.usuarioDTO = usuarioDTO;
        this.ultimaEjecucion = ultimaEjecucion2;
        this.comentario = comentario;
    }

    public int getNumeroAlarma() {
        return numeroAlarma;
    }

    public Duration getPeriodicidad() {
        return periodicidad;
    }

    public Animal getAnimalDTO() {
        return animal;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public Date getUltimaEjecucion() {
        return ultimaEjecucion;
    }

    public ArrayList<AccionDTO> getAcciones() {
        return tipoAlarma.getAccionesDTO();
    }

    public String getComentario() {
        return comentario;
    } 

    public void printAcciones() {
        for (AccionDTO accion : tipoAlarma.getAccionesDTO()) {
            System.out.println(ConsoleColors.BLUE + "Nombre: " + ConsoleColors.BLUE_BOLD + accion.getNombre() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Descripcion: " + ConsoleColors.BLUE_BOLD + accion.getDescripcion() + ConsoleColors.RESET);
        }
    }

}