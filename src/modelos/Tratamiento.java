package modelos;


import java.util.*;

import modelos.dtos.TratamientoDTO;

/**
 * 
 */
public class Tratamiento {

    private static int numero = 1;

    private Boolean finalizado; //Estado del tratamiento
    private int numeroTratamiento;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombre;
    private String descripcion;



    public Tratamiento(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.numeroTratamiento = numero++;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }



    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public int getNumeroTratamiento() {
        return numeroTratamiento;
    }

    public void setNumeroTratamiento(int numeroTratamiento) {
        this.numeroTratamiento = numeroTratamiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TratamientoDTO toDTO() {
        return new TratamientoDTO(this.finalizado, this.numeroTratamiento, this.fechaInicio, this.fechaFin, this.nombre, this.descripcion);
    }
}