package adaptador.notificacion;

import modelos.dtos.AlarmaDTO;
import color.ConsoleColors;

/**
 * 
 */
public class AdapterNotificacionPush implements INotificationPush {

    /**
     * Default constructor
     */
    public AdapterNotificacionPush() {
    }

    /**
     * @param AlarmaDTO alarmaNotf 
     * @return
     */
    @Override
    public void enviarNotificacion(AlarmaDTO alarmaDTO) {
        System.out.println(ConsoleColors.YELLOW + "Enviando notificacion push del animal " + ConsoleColors.YELLOW_BOLD + alarmaDTO.getAnimalDTO().getNombre() + ConsoleColors.YELLOW + " a todos los usuarios conectados."  + ConsoleColors.RESET);
    }

}