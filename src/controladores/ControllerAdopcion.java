package controladores;

import java.util.*;
import modelos.Adopcion;
import modelos.Animal;
import modelos.ClienteAdoptante;
import modelos.Usuario;
import modelos.dtos.AdopcionDTO;
import color.ConsoleColors;
import modelos.dtos.RecordatorioDTO;
import singleton.Escaner;

public class ControllerAdopcion {

    private ArrayList<Adopcion> adopciones;
    private static ControllerAdopcion instancia;

    public static ControllerAdopcion getInstancia() {
        if (instancia == null)
            instancia = new ControllerAdopcion();
        return instancia;
    }

    private ControllerAdopcion() {
        adopciones = new ArrayList<>();
    }

    public int crearAdopcion(int animal, String emailCliente, String motivoDeAdopcion, String emailVisitador) {
        ClienteAdoptante cliente1 = ControllerClienteAdoptante.getInstancia().buscarClienteAdoptante(emailCliente);
        Animal animal1 = ControllerAnimal.getInstancia().obtenerAnimal(animal);

        if (animal1.getAdoptado() == true)
            System.out.println(ConsoleColors.RED + "El animal " + ConsoleColors.RED_BOLD + animal1.getNombre() + ConsoleColors.RED + " ya fue adoptado previamente, no se puede adoptar" + ConsoleColors.RESET);

        else if (animal1.getEstadoSaludableAnimal() == false)
            System.out.println(ConsoleColors.RED + "El animal " + ConsoleColors.RED_BOLD + animal1.getNombre() + ConsoleColors.RED  + " NO esta saludable, no se puede adoptar" + ConsoleColors.RESET);
            
        else if (animal1.getDomestico() == false)
            System.out.println(ConsoleColors.RED + "El animal " + ConsoleColors.RED_BOLD + animal1.getNombre() + ConsoleColors.RED  + " NO es un animal domestico, no se puede adoptar" + ConsoleColors.RESET);
        
        else {
            //si falla
            Adopcion adopcion = cliente1.adopcionNueva(cliente1, animal1, motivoDeAdopcion);
            if (adopcion == null) {
                System.out.println(ConsoleColors.RED + "El cliente " + ConsoleColors.RED_BOLD + cliente1.getNombre() + " " + cliente1.getApellido() + ConsoleColors.RED  + " ya tiene 2 adopciones, no se puede adoptar" + ConsoleColors.RESET);
                return -1;
            }
            animal1.setAdoptado(true);
            Usuario visitador = ControllerUsuario.getInstancia().buscarUsuario(emailVisitador);
            adopcion.getSeguimiento().setVisitador(visitador);
            this.adopciones.add(adopcion);
            System.out.println(ConsoleColors.GREEN + "El animal " + ConsoleColors.GREEN_BOLD + animal1.getNombre() + ConsoleColors.GREEN + " fue adoptado!" + ConsoleColors.RESET);
            return adopcion.getnumeroAdopcion();
        }
        return -1;
    }

    public RecordatorioDTO enviarNotificacion(int numeroAdopcion) {
        Adopcion adopcion = this.buscarAdopcion(numeroAdopcion);
        RecordatorioDTO recordatorioDTO = new RecordatorioDTO(this.mensajeRecordatorio(), new Date(),
                adopcion.getCliente().toDTO());
        adopcion.enviarNotificacion(recordatorioDTO);
        return recordatorioDTO;
    }

    private String mensajeRecordatorio() {
        System.out.println(ConsoleColors.YELLOW + "Mensaje de recordatorio:" + ConsoleColors.RESET);
        String mensajeRecordatorio = Escaner.getInstancia().proxLinea();
        return mensajeRecordatorio;
    }

    protected Adopcion buscarAdopcion(int numero) {
        Adopcion adopcionBuscada = null;
        for (Adopcion adopcion : adopciones) {
            if (adopcion.getnumeroAdopcion() == numero) {
                adopcionBuscada = adopcion;
            }
        }
        return adopcionBuscada;
    }

    public AdopcionDTO buscarAdopcionDTO(int numeroAdopcion) {
        Adopcion adopcion = this.buscarAdopcion(numeroAdopcion);
        if (adopcion instanceof Adopcion) {
            return adopcion.toDTO();
        }
        return null;
    }

}
