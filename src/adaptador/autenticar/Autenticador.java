package adaptador.autenticar;
import color.ConsoleColors;

public class Autenticador implements AdapterAutenticador {
    public Autenticador() {
    }
    public boolean autenticarse(String email, String nombre) {
    	System.out.println(ConsoleColors.GREEN + "El usuario " + email +  " se autenticó correctamente" + ConsoleColors.RESET);
        return true;
    }

}