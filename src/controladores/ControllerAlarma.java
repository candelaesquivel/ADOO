package controladores;

import java.time.Duration;
import java.util.ArrayList;

import estrategias.accion.AlarmaControl;
import estrategias.accion.AlarmaTratamiento;
import estrategias.accion.ITipoAlarma;
import modelos.Alarma;
import modelos.Animal;
import modelos.FichaMedica;
import modelos.Tratamiento;
import modelos.Usuario;
import modelos.dtos.AlarmaDTO;
import color.ConsoleColors;

public class ControllerAlarma {

    private static ControllerAlarma instancia;

    private ArrayList<Alarma> alarmas;

    private ControllerAlarma() {
        alarmas = new ArrayList<Alarma>();
    }

    public static ControllerAlarma getInstancia() {
        if (instancia == null)
            instancia = new ControllerAlarma();
        return instancia;
    }

    public int crearAlarma(
            Duration periodicidad,
            int legajoAnimal) {
        ITipoAlarma tipoAlarma = new AlarmaControl();
        Animal animal = ControllerAnimal.getInstancia().obtenerAnimal(legajoAnimal);
        Alarma alarma = new Alarma(periodicidad, animal, tipoAlarma);
        this.alarmas.add(alarma);

        return alarma.getNumeroAlarma();
    }

    public int crearAlarma(
            Duration periodicidad,
            int legajoAnimal,
            int numeroDetratamiento) {
        Animal animal = ControllerAnimal.getInstancia().obtenerAnimal(legajoAnimal);
        FichaMedica fichaMedica = ControllerFichaMedica.getInstancia().buscarFichaMedica(legajoAnimal);
        Tratamiento tratamiento = fichaMedica.buscarTratamiento(numeroDetratamiento);
        ITipoAlarma tipoAlarma = new AlarmaTratamiento(tratamiento);
        Alarma alarma = new Alarma(periodicidad, animal, tipoAlarma);
        this.alarmas.add(alarma);
        fichaMedica.agregarAlarma(alarma);

        return alarma.getNumeroAlarma();
    }

    protected Alarma buscarAlarma(int numeroAlarma) {
        for (Alarma alarma : alarmas) {
            if (alarma.soyAlarma(numeroAlarma)) {
                return alarma;
            }
        }
        return null;
    }

    public AlarmaDTO obtenerAlarmaDTO(int numeroAlarma) {
        Alarma alarma = buscarAlarma(numeroAlarma);
        return alarma.toDTO();
    }

    public void atenderAlarma(int numeroAlarma, String emailVeterinario) {
        Alarma alarma = buscarAlarma(numeroAlarma);
        alarma.atenderAlarma();
        Usuario veterinario = ControllerUsuario.getInstancia().buscarUsuario(emailVeterinario);
        alarma.setVeterinario(veterinario);
        System.out.println(ConsoleColors.GREEN + "Alarma atendida por el veterinario " + ConsoleColors.GREEN_BOLD + veterinario.getNombre() + ConsoleColors.GREEN + "." + ConsoleColors.RESET);
    }

    public void enviarNotificacion(int numeroAlarma) {
        Alarma alarma = buscarAlarma(numeroAlarma);
        alarma.enviarNotificacion();
    }
}