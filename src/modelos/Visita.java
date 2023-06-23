package modelos;
import java.util.*;

import enums.Calificacion;

public class Visita {
    
    private String comentario;
    private Date fecha;
    private Usuario visitador;
    private Encuesta encuesta;
    
    public Visita(String comentario, Usuario visitador) {
    	this.comentario = comentario;
    	this.visitador = visitador;
    	this.fecha = new Date();
    }
    
    public void completarEncuesta(Calificacion estadoAnimal, Calificacion limpieza, Calificacion ambiente) {
    	this.encuesta = new Encuesta(estadoAnimal, limpieza, ambiente);
    }    
    
    public String getComentario () {
    	return this.comentario;
    }
    
    public Date getFecha () {
    	return this.fecha;
    }
    
    public Usuario getVisitador () {
    	return this.visitador;
    }

    public Encuesta getEncuesta () {
    	return this.encuesta;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setVisitador(Usuario visitador) {
        this.visitador = visitador;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
    
}