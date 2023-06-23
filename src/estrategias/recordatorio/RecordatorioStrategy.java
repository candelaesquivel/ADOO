package estrategias.recordatorio;

import modelos.dtos.RecordatorioDTO;

/**
 * 
 */
public interface RecordatorioStrategy {

    /**
     * @param recordatorio 
     * @return void
     */
    public void enviarRecordatorio(RecordatorioDTO recordatorio);

}