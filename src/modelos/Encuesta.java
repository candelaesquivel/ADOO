package modelos;

import enums.Calificacion;

public class Encuesta {
    private Calificacion estadoAnimal;
    private Calificacion limpieza;
    private Calificacion ambiente;

    public Encuesta(Calificacion estadoAnimal, Calificacion limpieza, Calificacion ambiente) {
    	this.estadoAnimal = estadoAnimal;
    	this.limpieza = limpieza;
    	this.ambiente = ambiente;
    }
    
    public Calificacion getCalificacionEstado() {
    	return this.estadoAnimal;
    }
    
    public Calificacion getLimpieza() {
    	return this.limpieza;
    }
    
    public Calificacion getAmbiente() {
    	return this.ambiente;
    }
}