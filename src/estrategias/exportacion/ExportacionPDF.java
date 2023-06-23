package estrategias.exportacion;

import adaptador.exportador.pdf.AdapterExportadorPDF;
import adaptador.exportador.pdf.AdapterPDF;
import modelos.dtos.FichaMedicaDTO;

public class ExportacionPDF implements ExportacionStrategy {

    AdapterExportadorPDF adapter;

    public ExportacionPDF() {
        this.adapter = new AdapterPDF();
    }
    
    /**
     * @param fichaMedica 
     * @return
     */

    @Override
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica) {
        this.adapter.exportarFichaMedica(fichaMedica);
    }

}