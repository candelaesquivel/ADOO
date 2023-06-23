package controladores;

import java.util.*;

import estrategias.exportacion.ExportacionExcel;
import estrategias.exportacion.ExportacionPDF;
import modelos.FichaMedica;
import modelos.Tratamiento;
import modelos.Animal;
import modelos.dtos.FichaMedicaDTO;
import enums.TipoExportacion;
import color.ConsoleColors;
/**
 * 
 */
public class ControllerFichaMedica {

    private ArrayList<FichaMedica> fichasMedicas;
    private static ControllerFichaMedica instancia;

    private ControllerFichaMedica() {
        fichasMedicas = new ArrayList<FichaMedica>();
    }

    public static ControllerFichaMedica getInstancia() {
        if (instancia == null)
            instancia = new ControllerFichaMedica();
        return instancia;
    }

    public void agregarFichaMedica(FichaMedica fichaMedica) {
        fichasMedicas.add(fichaMedica);
    }

    protected FichaMedica buscarFichaMedica(int legajo) {
        FichaMedica fichaM = null;
        for (FichaMedica FichaMedica : fichasMedicas) {
            if (FichaMedica.getLegajo() == (legajo)) {
                fichaM = FichaMedica;
                break;
            }
        }
        return fichaM;
    }

    // acá esta tipoExportacion es un String, no un enum. Hay que cambiarlo
    public void exportarFichaMedica(int legajo) {
        FichaMedica fichaMedica = buscarFichaMedica(legajo);
        fichaMedica.exportarFichaMedica();
    }

    public void cambiarEstrategiaExportacion(TipoExportacion tipoExportacion, int legajo){
        FichaMedica fichaMedica = buscarFichaMedica(legajo);

        switch (tipoExportacion) {
            case PDF:
                fichaMedica.getExportador().setEstrategia(new ExportacionPDF());
                break;
            case EXCEL:
                fichaMedica.getExportador().setEstrategia(new ExportacionExcel());
                break;
        }

    }

    public int crearTratamiento(String nombre, String descripcion, Date fechaInicio, Date fechaFin, int legajo) {
        FichaMedica fichaMedica = buscarFichaMedica(legajo);
        if (fichaMedica.getEstadoSaludableAnimal()) { 
            Tratamiento tratamiento = new Tratamiento(nombre, descripcion, fechaInicio, fechaFin);
            fichaMedica.agregarTratamiento(tratamiento);
            ControllerAnimal.getInstancia().setEstadoSaludableAnimal(legajo, false);
            System.out.println(ConsoleColors.GREEN + "Se ha creado el tratamiento: " + ConsoleColors.GREEN_BOLD + tratamiento.getNombre() + ConsoleColors.GREEN + " con id: "
                    + ConsoleColors.GREEN_BOLD + tratamiento.getNumeroTratamiento() + ConsoleColors.RESET);
            return tratamiento.getNumeroTratamiento();
        } else {
            System.out.println(ConsoleColors.RED + "Ya existe un tratamiento en curso, no se puede crear otro" + ConsoleColors.RESET);
            return fichaMedica.getTratamientoActivo().getNumeroTratamiento();
        }
    }

    public void finalizarTratamiento(int legajo, int numeroTratamiento) {
        Animal animal = ControllerAnimal.getInstancia().obtenerAnimal(legajo);
        Tratamiento tratamiento = animal.getFichaMedica().buscarTratamiento(numeroTratamiento);
        tratamiento.setFinalizado(true);
        ControllerAnimal.getInstancia().setEstadoSaludableAnimal(legajo, true);
        System.out.println(ConsoleColors.GREEN + 
                "Ha finalizado el tratamiento: " + ConsoleColors.GREEN_BOLD + tratamiento.getNombre() + ConsoleColors.GREEN + ", ahora el animal " + ConsoleColors.GREEN_BOLD + animal.getNombre() + ConsoleColors.GREEN + " esta SALUDABLE" + ConsoleColors.RESET);
    }

    protected FichaMedica obtenerFichaMedica(int legajo) {
        for (FichaMedica fichaMedica : fichasMedicas) {
            if (fichaMedica.getLegajo() == legajo) {
                return fichaMedica;
            }
        }
        return null;
    }

    public FichaMedicaDTO obtenerFichaMedicaDTO(int legajo) {
        FichaMedica fichaMedica = this.obtenerFichaMedica(legajo);
        if (fichaMedica instanceof FichaMedica) {
            return fichaMedica.toDTO();
        }
        return null;
    }
}