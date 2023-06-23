package adaptador.exportador.excel;

import modelos.dtos.FichaMedicaDTO;
import color.ConsoleColors;

public class AdapterExcel implements AdapterExportadorExcel {
    
    public AdapterExcel() {
    }

    /**
     * @param fichaMedica 
     * @return void
     */
    @Override
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha exportado la ficha medica de legajo: "+ fichaMedica.getLegajo() + " en formato Excel" + ConsoleColors.RESET
        );
    }

}