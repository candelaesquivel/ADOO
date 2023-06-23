package modelos;

import java.util.*;
import modelos.dtos.*;

public class FichaMedica {
    
    private int legajo;
    private Exportador exportador;
    private ArrayList <Tratamiento> tratamientos;
    private ArrayList <Alarma> alarmas;
    private Animal animal;

    public FichaMedica(Animal animal) {
        this.animal = animal;
        this.legajo = animal.getLegajo();
        this.tratamientos = new ArrayList<Tratamiento>();
        this.alarmas = new ArrayList<Alarma>();
        this.exportador = new Exportador();
    }

    //Getters
    public Exportador getExportador() {
        return exportador;
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public ArrayList<Alarma> getAlarmas() {
        return alarmas;
    }
    //Fin Getters
    
    //Setters
    public void setExportador(Exportador exportador) {
        this.exportador = exportador;
    }

    public void setAlarmas(ArrayList<Alarma> alarmas) {
        this.alarmas = alarmas;
    }
    //Fin Setters

    public void exportarFichaMedica() {
        this.exportador.exportarFichaMedica(this.toDTO());
    }

    //Inicio Tratamientos

    public Tratamiento buscarTratamiento(int numeroTratamiento) {
        Tratamiento tratamiento = null;
        for (Tratamiento t : tratamientos) {
            if (t.getNumeroTratamiento() == numeroTratamiento) {
                tratamiento = t;
                break;
            }
        }
        return tratamiento;
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    public FichaMedicaDTO toDTO() {
        ArrayList<TratamientoDTO> tratamientosDTO = new ArrayList<TratamientoDTO>();
        ArrayList<AlarmaDTO> alarmasDTO = new ArrayList<AlarmaDTO>();
        for (Tratamiento t : tratamientos) {
            tratamientosDTO.add(t.toDTO());
        }
        for (Alarma a : alarmas) {
            alarmasDTO.add(a.toDTO());
        }
        return new FichaMedicaDTO(tratamientosDTO, alarmasDTO, this.animal, this.legajo);
    }

    public int getLegajo(){
        return this.legajo;
    }

    public void setLegajo(int legajo){
        this.legajo = legajo;
    }
    //Fin tratamientos

	public boolean getEstadoSaludableAnimal() {
		return this.animal.getEstadoSaludableAnimal();
	}

	public Tratamiento getTratamientoActivo() {
        return this.tratamientos.get(this.tratamientos.size() - 1);
	}

    public void agregarAlarma(Alarma alarma) {
        this.alarmas.add(alarma);
    }
}