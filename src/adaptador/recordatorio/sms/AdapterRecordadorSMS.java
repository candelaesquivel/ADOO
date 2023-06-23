package adaptador.recordatorio.sms;

import modelos.dtos.RecordatorioDTO;

public interface AdapterRecordadorSMS {

    /**
     * @param recordatorio 
     * @return void
     */
    public void enviarRecordatorio(RecordatorioDTO recordatorio);

}