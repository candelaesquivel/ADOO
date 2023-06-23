package estrategias.exportacion;

import modelos.dtos.FichaMedicaDTO;
public interface ExportacionStrategy {

    /**
     * @param fichaMedica 
     * @return
     */
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica);

}