package modelos.dtos;

import java.util.Date;

public class TratamientoDTO {

    private Boolean finalizado;
    private int numeroTratamiento;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombre;
    private String descripcion;

    public TratamientoDTO(Boolean finalizado, int numeroTratamiento, Date fechaInicio, Date fechaFin, String nombre,
            String descripcion) {
        this.finalizado = finalizado;
        this.numeroTratamiento = numeroTratamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public int getNumeroTratamiento() {
        return numeroTratamiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
