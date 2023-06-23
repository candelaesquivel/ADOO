package estados.alarma;

import color.ConsoleColors;
import estrategias.accion.Accion;

/**
 * 
 */
public class Completa implements IEstadoAccion {

    public Completa() {
    }

    @Override
    public void atenderAccion(Accion accion) {
        System.out.println(ConsoleColors.RED + "Acción ya atendida" + ConsoleColors.RESET);
    }

    @Override
    public boolean getFinalizada() {
        return true;
    }

}