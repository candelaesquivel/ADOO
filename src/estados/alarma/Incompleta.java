package estados.alarma;

import color.ConsoleColors;
import estrategias.accion.Accion;

/**
 * 
 */
public class Incompleta implements IEstadoAccion {

    public Incompleta() {
    }

    /**
     * @param Alarma alarma
     * @return
     */
    @Override
    public void atenderAccion(Accion accion) {
        System.out.println(ConsoleColors.YELLOW + "Atendiendo accion: " + ConsoleColors.YELLOW_BOLD + accion.getNombre() + ConsoleColors.RESET);
        accion.setEstadoAlarma(new Completa());
    }

    @Override
    public boolean getFinalizada() {
        return false;
    }

}