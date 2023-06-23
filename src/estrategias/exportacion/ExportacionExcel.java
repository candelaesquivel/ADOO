package estrategias.exportacion;

import adaptador.exportador.excel.AdapterExcel;
import adaptador.exportador.excel.AdapterExportadorExcel;
import modelos.dtos.FichaMedicaDTO;

public class ExportacionExcel implements ExportacionStrategy {

    AdapterExportadorExcel adapter;

    public ExportacionExcel() {
        this.adapter = new AdapterExcel();
    }

    /**
     * @param fichaMedica 
     * @return void
     */
    @Override
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica) {
        this.adapter.exportarFichaMedica(fichaMedica);
    }

}