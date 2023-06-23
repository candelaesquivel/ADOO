package estrategias.recordatorio;

import adaptador.recordatorio.email.AdapterEmail;
import adaptador.recordatorio.email.AdapterRecordadorEmail;
import modelos.dtos.RecordatorioDTO;

public class RecordatorioPorEmail implements RecordatorioStrategy {
    
    private AdapterRecordadorEmail adapter;
    
    public RecordatorioPorEmail() {
        this.adapter = new AdapterEmail();
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