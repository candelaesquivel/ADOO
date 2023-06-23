package adaptador.exportador.pdf;

import modelos.dtos.FichaMedicaDTO;

public interface AdapterExportadorPDF {

    /**
     * @param fichaMedica 
     * @return void
     */
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica);

}