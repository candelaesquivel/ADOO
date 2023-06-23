package modelos;

import java.util.*;

import enums.Calificacion;
import modelos.dtos.RecordatorioDTO;
import estrategias.recordatorio.RecordatorioPorEmail;
import estrategias.recordatorio.RecordatorioPorWhatsApp;
import estrategias.recordatorio.RecordatorioPorSMS;
import color.ConsoleColors;

public class Seguimiento {
    private static int numeradorSeguiemiento = 1;

    // atributos
    private Boolean continuarSeguimiento;
    private int numeroSeguimiento;
    private Recordador recordador;
    private int frecuenciaVisita; // cada cuanto se repite
    private ArrayList<Visita> visitas;
    private Usuario visitadorEncargado;

    // constructor
    public Seguimiento() {
        this.recordador = new Recordador(new RecordatorioPorSMS());
        this.numeroSeguimiento = numeradorSeguiemiento++;
        this.visitas = new ArrayList<Visita>();
    }

    // metodos
    public void agregarVisita(String comentario, Calificacion estadoAnimal, Calificacion limpieza,
            Calificacion ambiente) {
        Visita visitaNueva = new Visita(comentario, this.visitadorEncargado);
        visitaNueva.completarEncuesta(estadoAnimal, limpieza, ambiente);
        visitas.add(visitaNueva);
        // solo para probar
        System.out.println(ConsoleColors.GREEN + "Se creo la visita con el comentario: " + ConsoleColors.GREEN_BOLD + "\"" + visitaNueva.getComentario()
                +"\"" + ConsoleColors.GREEN + ". Tenes esta cantidad de visitas: " + ConsoleColors.GREEN_BOLD + cantidadVisitas() + ConsoleColors.RESET);
    }

    public int cantidadVisitas() {
        return visitas.size();
    }
    
    public void enviarRecordatorio(RecordatorioDTO recordatorio) {
        switch (recordatorio.getDestinatario().getTipoNotificacion()) {
            case EMAIL:
                recordador.setEstrategia(new RecordatorioPorEmail());
                break;
            case SMS:
                recordador.setEstrategia(new RecordatorioPorSMS());
                break;
            case WHATSAPP:
                recordador.setEstrategia(new RecordatorioPorWhatsApp());
                break;
        }
        this.recordador.enviarRecordatorio(recordatorio);
    }

    // getters 
    public Boolean getContinuarSeguimiento() {
        return continuarSeguimiento;
    }

    public int getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public Recordador getRecordador() {
        return recordador;
    }

    public int getFrecuenciaVisita() {
        return frecuenciaVisita;
    }

    public ArrayList<Visita> getVisitas() {
        return visitas;
    }
    
    // setters
    public void setRecordador(Recordador recordador) {
        this.recordador = recordador;
    }

    public void setContinuarSeguimiento(Boolean continuarSeguimiento) {
        this.continuarSeguimiento = continuarSeguimiento;
    }

    public void setFrecuenciaVisita(int frecuenciaVisita) {
        this.frecuenciaVisita = frecuenciaVisita;
    }

    public void setVisitador(Usuario visitador) {
        this.visitadorEncargado = visitador;
    }

}