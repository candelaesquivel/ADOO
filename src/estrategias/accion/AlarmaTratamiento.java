package estrategias.accion;

import java.util.ArrayList;

import modelos.Tratamiento;
import modelos.dtos.AccionDTO;
import singleton.Escaner;
import color.ConsoleColors;

public class AlarmaTratamiento implements ITipoAlarma {
    // atributos
    private ArrayList<Accion> acciones;
    private Tratamiento tratamiento;

    // constructor
    public AlarmaTratamiento(Tratamiento tratamiento) {
        acciones = new ArrayList<Accion>();
        this.tratamiento = tratamiento;
        crearAlarma();
    }

    @Override
    public void atenderAlarma() {
        System.out.println(ConsoleColors.YELLOW + "Ejecutando alarma de tratamiento" + ConsoleColors.RESET);
        for (Accion accion : acciones) {
            accion.atenderAccion();
        }
        if(accionesTerminadas()){
            tratamiento.setFinalizado(true);
            System.out.println(ConsoleColors.GREEN + "Alarma de tratamiento atendida" + ConsoleColors.RESET);
        }
    }

    private boolean accionesTerminadas() {
        boolean terminadas = true;
        for (Accion accion : acciones) {
            if(!accion.getFinalizada()){
                terminadas = false;
                break;
            }
        }
        return terminadas;
    }

    private void crearAlarma() {
        System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese las acciones a realizar para esta alarma de tratamiento" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese el nombre de la accion, utilize 'x' para salir" + ConsoleColors.RESET);
        String nombreAccion = Escaner.getInstancia().proxLinea();

        while (nombreAccion.equals("x")) {
            System.out.println(ConsoleColors.RED_BOLD + "La alarma sin acciones no puede ser creada" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese el nombre de la accion, utilize 'x' para salir" + ConsoleColors.RESET);
            nombreAccion = Escaner.getInstancia().proxLinea();
        }

        while (!nombreAccion.equals("x")) {

            System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese la descripcion de la accion" + ConsoleColors.RESET);
            String descripcionAccion = Escaner.getInstancia().proxLinea();

            Accion accion = new Accion(nombreAccion, descripcionAccion);
            acciones.add(accion);// aca guardamos las acciones de la alarma control

            System.out.println(ConsoleColors.BLUE_BOLD + "Ingrese el nombre de la accion, utilize 'x' para salir" + ConsoleColors.RESET);
            nombreAccion = Escaner.getInstancia().proxLinea();
        }
        System.out.println(ConsoleColors.GREEN + "La alarma quedo seteada para el TRATAMIENTO del animal" + ConsoleColors.RESET);
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public ArrayList<AccionDTO> getAccionesDTO() {
        ArrayList<AccionDTO> accionesDTO = new ArrayList<AccionDTO>();
        for (Accion accion : acciones) {
            AccionDTO accionDTO = new AccionDTO(accion.getNombre(), accion.getDescripcion());
            accionesDTO.add(accionDTO);
        }
        return accionesDTO;
    }
}
