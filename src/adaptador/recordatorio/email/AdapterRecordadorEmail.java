package adaptador.recordatorio.email;

import modelos.dtos.RecordatorioDTO;

public interface AdapterRecordadorEmail {

    /**
     * @param recordatorio 
     * @return void
     */
    public void enviarRecordatorio(RecordatorioDTO recordatorio);

}