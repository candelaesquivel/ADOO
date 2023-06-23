package adaptador.recordatorio.whatsapp;

import modelos.dtos.RecordatorioDTO;
import color.ConsoleColors;

public class AdapterWhatsApp implements AdapterRecordadorWhatsApp {
    public AdapterWhatsApp() {
    }

    /**
     * @param recordatorio 
     * @return
     */
    @Override
    public void enviarRecordatorio(RecordatorioDTO recordatorio) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha enviado un mensaje por Whatsapp al numero " + ConsoleColors.GREEN_BOLD + recordatorio.getDestinatario().getTelefono() + ConsoleColors.GREEN
                        + " del Cliente Adoptante " + ConsoleColors.GREEN_BOLD + recordatorio.getDestinatario().getNombre()
                        + " " + recordatorio.getDestinatario().getApellido() + ConsoleColors.GREEN +
                        " en la fecha " + ConsoleColors.GREEN_BOLD + recordatorio.getFecha() + ConsoleColors.GREEN + " con el mensaje: "+ ConsoleColors.GREEN_BOLD + "\"" + recordatorio.getMensaje() + "\"" + ConsoleColors.RESET
        );
    }

}