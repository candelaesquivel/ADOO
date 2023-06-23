package modelos;

import estrategias.recordatorio.RecordatorioStrategy;
import modelos.dtos.RecordatorioDTO;

public class Recordador {
    
    private RecordatorioStrategy estrategiaRecordatorio;

    public Recordador(RecordatorioStrategy estrategiaRecordatorio) {
        this.estrategiaRecordatorio = estrategiaRecordatorio;
    }
    /**
     * @param recodatorio 
     * @return void
     */
    public void enviarRecordatorio(RecordatorioDTO recodatorio) {
        this.estrategiaRecordatorio.enviarRecordatorio(recodatorio);
    }
   
    public void setEstrategia(RecordatorioStrategy estrategiaRecordatorio) {
        this.estrategiaRecordatorio = estrategiaRecordatorio;
    }

}