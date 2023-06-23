package adaptador.recordatorio.whatsapp;

import modelos.dtos.RecordatorioDTO;

/**
 * 
 */
public interface AdapterRecordadorWhatsApp {

    /**
     * @param recordatorio 
     * @return
     */
    public void enviarRecordatorio(RecordatorioDTO recordatorio);

}