package modelos;

import java.time.Duration;
import java.util.*;

import adaptador.notificacion.AdapterNotificacionPush;
import adaptador.notificacion.INotificationPush;
import estrategias.accion.ITipoAlarma;
import modelos.dtos.AlarmaDTO;
import modelos.dtos.UsuarioDTO;
import singleton.Escaner;
import color.ConsoleColors;

public class Alarma {

    // Atributos
    private static int numeradorAlarma = 1;
    private int numeroAlarma;
    private Duration periodicidad;
    private Animal animal;
    private INotificationPush notificacion;
    private ITipoAlarma tipoAlarma;
    private Usuario veterinario;
    private Date ultimaEjecucion;
    private String comentario;

    // Constructor
    public Alarma(Duration periodicidad, Animal animal,
            ITipoAlarma tipoAlarma) {
        this.periodicidad = periodicidad;
        this.animal = animal;
        this.notificacion = new AdapterNotificacionPush();
        this.tipoAlarma = tipoAlarma;
        this.veterinario = null;
        this.ultimaEjecucion = new Date();
        this.numeroAlarma = numeradorAlarma++;
    }

    // Metodos

    public void enviarNotificacion() {
        this.notificacion.enviarNotificacion(toDTO());
    }

    public boolean soyAlarma(int numeroAlarma) {
        return this.numeroAlarma == numeroAlarma;
    }

    public AlarmaDTO toDTO() {
        UsuarioDTO veterinarioDTO = null;

        if (this.veterinario != null) {
            veterinarioDTO = this.veterinario.toDTO();
        }
        return new AlarmaDTO(this.numeroAlarma, this.periodicidad, this.animal, this.tipoAlarma,
                veterinarioDTO, this.ultimaEjecucion, this.comentario);
    }

    // Getters
    public Duration getPeriodicidad() {
        return periodicidad;
    }

    public Animal getAnimal() {
        return animal;
    }

    public INotificationPush getNotificacion() {
        return notificacion;
    }

    public ITipoAlarma getTipoAlarma() {
        return tipoAlarma;
    }

    public Usuario getVeterinario() {
        return veterinario;
    }

    public Date getUltimaEjecucion() {
        return ultimaEjecucion;
    }

    public int getNumeroAlarma() {
        return numeroAlarma;
    }

    public String getComentario() {
        return comentario;
    }

    public void setPeriodicidad(Duration periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setNotificacion(INotificationPush notificacion) {
        this.notificacion = notificacion;
    }

    public void setTipoAlarma(ITipoAlarma tipoAlarma) {
        this.tipoAlarma = tipoAlarma;
    }

    public void setVeterinario(Usuario veterinario) {
        this.veterinario = veterinario;
    }

    public void setUltimaEjecucion(Date ultimaEjecucion) {
        this.ultimaEjecucion = ultimaEjecucion;
    }

    public void atenderAlarma() {
        tipoAlarma.atenderAlarma();

        if(comentario == null) {

            System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese un comentario: " + ConsoleColors.RESET);

            this.comentario = Escaner.getInstancia().proxLinea();
        }
    }

}