package estados.alarma;

import estrategias.accion.Accion;

/**
 * 
 */
public interface IEstadoAccion {

    public void atenderAccion(Accion Accion);

    public boolean getFinalizada();

}