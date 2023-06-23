package adaptador.exportador.excel;

import modelos.dtos.FichaMedicaDTO;

public interface AdapterExportadorExcel {

    /**
     * @param fichaMedica 
     * @return void
     */
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica);

}