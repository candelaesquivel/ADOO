package adaptador.recordatorio.email;

import modelos.dtos.RecordatorioDTO;
import color.ConsoleColors;
/**
 * 
 */
public class AdapterEmail implements AdapterRecordadorEmail {

    /**
     * Default constructor
     */
    public AdapterEmail() {
    }

    /**
     * @param recordatorio 
     * @return
     */
    @Override
    public void enviarRecordatorio(RecordatorioDTO recordatorio) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha enviado un mensaje por Email al correo " + ConsoleColors.GREEN_BOLD + recordatorio.getDestinatario().getEmail() + ConsoleColors.GREEN
                        + " del Cliente Adoptante " + ConsoleColors.GREEN_BOLD + recordatorio.getDestinatario().getNombre() 
                        + " " + recordatorio.getDestinatario().getApellido() + ConsoleColors.GREEN + 
                        " en la fecha " + ConsoleColors.GREEN_BOLD + recordatorio.getFecha() + ConsoleColors.GREEN + " con el mensaje: " + ConsoleColors.GREEN_BOLD + "\"" + recordatorio.getMensaje() + "\"" + ConsoleColors.RESET
        );
    }

}