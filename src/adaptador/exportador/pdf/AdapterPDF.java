package adaptador.exportador.pdf;

import modelos.dtos.FichaMedicaDTO;
import color.ConsoleColors;

public class AdapterPDF implements AdapterExportadorPDF {

    public AdapterPDF() {
    }

    /**
     * @param fichaMedica 
     * @return void
     */
    @Override
    public void exportarFichaMedica(FichaMedicaDTO fichaMedica) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha exportado la ficha medica de legajo: "+ fichaMedica.getLegajo() + " en formato PDF" + ConsoleColors.RESET
        );
    }

}