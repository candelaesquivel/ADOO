package modelos;

import estrategias.exportacion.ExportacionPDF;
import estrategias.exportacion.ExportacionStrategy;
import modelos.dtos.FichaMedicaDTO;

public class Exportador {
    
    private ExportacionStrategy estrategiaExportacion;

    public Exportador() {
        this.estrategiaExportacion = new ExportacionPDF();
    }

    /**
     * @param fichaMedica
     */
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica) {
        this.estrategiaExportacion.exportarFichaMedica(fichaMedica);
    }

    /**
     * @param estrategiaExportacion 
     * @return
     */
    public void setEstrategia(ExportacionStrategy estrategiaExportacion) {
        this.estrategiaExportacion = estrategiaExportacion;
    }

}