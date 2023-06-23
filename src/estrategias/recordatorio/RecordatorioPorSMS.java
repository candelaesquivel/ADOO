package estrategias.recordatorio;

import adaptador.recordatorio.sms.AdapterSMS;
import adaptador.recordatorio.sms.AdapterRecordadorSMS;
import modelos.dtos.RecordatorioDTO;
public class RecordatorioPorSMS implements RecordatorioStrategy {
    
    private AdapterRecordadorSMS adapter;
    
    public RecordatorioPorSMS() {
        this.adapter = new AdapterSMS();
    }

    /**
     * @param recordatorio 
     * @return void
     */
    @Override
    public void enviarRecordatorio(RecordatorioDTO recordatorio) {
        this.adapter.enviarRecordatorio(recordatorio);
    }

}