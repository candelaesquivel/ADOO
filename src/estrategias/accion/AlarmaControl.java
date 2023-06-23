package estrategias.accion;

import java.util.ArrayList;

import modelos.dtos.AccionDTO;
import singleton.Escaner;
import color.ConsoleColors;

public class AlarmaControl implements ITipoAlarma {

    // atributos
    private ArrayList<Accion> acciones;

    // constructor
    public AlarmaControl() {

        acciones = new ArrayList<Accion>();
        crearAlarma();
    }

    @Override
    public void atenderAlarma() {
        System.out.println(ConsoleColors.YELLOW + "Se esta atendiendo la alarma de control" + ConsoleColors.RESET);
        for (Accion accion : acciones) {
            accion.atenderAccion();
        }
        System.out.println(ConsoleColors.GREEN + "Se termino de atender la alarma de control" + ConsoleColors.RESET);
    }

    private void crearAlarma() {
        System.out.println(ConsoleColors.WHITE_BOLD + "Ingrese las acciones a realizar para esta alarma de control");
        System.out.println("Acciones disponibles: ");
        System.out.println("1. Control de parasitos");
        System.out.println("2. Colocar antiparasitos");
        System.out.println("3. Comprobar peso y tamaño");
        System.out.println("4. Chequear nutricion");
        System.out.println("5. Colocar vacuna" + ConsoleColors.RESET);

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
        System.out.println(ConsoleColors.GREEN + "La alarma quedo seteada para el CONTROL del animal " + ConsoleColors.RESET);
    }

    @Override
    public ArrayList<AccionDTO> getAccionesDTO() {
        ArrayList<AccionDTO> accionesDTO = new ArrayList<AccionDTO>();
        for (Accion accion : acciones) {
            AccionDTO accionDTO = new AccionDTO(accion.getNombre(), accion.getDescripcion());
            accionesDTO.add(accionDTO);
        }
        return accionesDTO;
    }

}
