package test;

import java.util.*;

import color.ConsoleColors;
import java.time.Duration;
import controladores.*;
import modelos.dtos.*;
import singleton.Escaner;
import enums.*;

public class App {

        public static void main(String[] args) throws Exception {

                ControllerAdopcion controladorAdopcion = ControllerAdopcion.getInstancia();
                ControllerAlarma controladorAlarma = ControllerAlarma.getInstancia();
                ControllerAnimal controladorAnimal = ControllerAnimal.getInstancia();
                ControllerFichaMedica controladorFichaMedica = ControllerFichaMedica.getInstancia();
                ControllerSeguimiento controladorSeguimiento = ControllerSeguimiento.getInstancia();
                ControllerUsuario controladorUsuario = ControllerUsuario.getInstancia();
                ControllerClienteAdoptante controladorClienteAdoptante = ControllerClienteAdoptante.getInstancia();
                Escaner controladorScanner = Escaner.getInstancia();

                ArrayList<TipoAnimal> tipoAnimales = new ArrayList<TipoAnimal>();

                // Crear un cliente

                tipoAnimales.add(TipoAnimal.GATO);
                tipoAnimales.add(TipoAnimal.PERRO);
                controladorClienteAdoptante.crearCliente("John", "Doe", "Soltero", "john.doe@example.com", "123456789",
                                "Estudiante", tipoAnimales, false, TipoNotificacion.WHATSAPP, "Amor a los animales", 0);

                ClienteAdoptanteDTO clienteEncontrado = controladorClienteAdoptante
                                .buscarClienteAdoptanteDTO("john.doe@example.com");

                System.out.println(ConsoleColors.RESET + ConsoleColors.GREEN_BACKGROUND + "El cliente " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellido()
                                + " fue cargado" + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();
                
                // crear usuario visitador y autenticar
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Crear y autenticar usuario visitador: " + ConsoleColors.RESET);
                String emailVisitador = controladorUsuario.agregarUsuario("lumolina@uade.edu.ar", "Lucas",
                                TipoUsuario.VISITADOR);
                controladorUsuario.autenticar(emailVisitador);

                Escaner.getInstancia().proxLinea();

                // crear usuario veterinario y autenticar
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Crear y autenticar usuario veterinario: " + ConsoleColors.RESET);
                controladorUsuario.agregarUsuario("caesquivel@uade.edu.ar", "Candela", TipoUsuario.VETERINARIO);
                controladorUsuario.autenticar("caesquivel@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // Crear 4 animales

                int legajo = controladorAnimal.ingresarAnimal(true, (float) 2.0, (float) 3.0, 5, true, TipoAnimal.GATO,
                                "Shona");
                AnimalDTO animalEncontrado = controladorAnimal.obtenerAnimalDTO(legajo);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "El animal " + animalEncontrado.getNombre() + " fue cargado con el legajo: "
                                + animalEncontrado.getLegajo() + ConsoleColors.RESET);
                                
                Escaner.getInstancia().proxLinea();

                int legajo2 = controladorAnimal.ingresarAnimal(true, (float) 2.0, (float) 3.0, 2, true,
                                TipoAnimal.PERRO, "Panchito");
                AnimalDTO animalEncontrado2 = controladorAnimal.obtenerAnimalDTO(legajo2);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "El animal " + animalEncontrado2.getNombre() + " fue cargado con el legajo: "
                                + animalEncontrado2.getLegajo() + ConsoleColors.RESET);
                                
                Escaner.getInstancia().proxLinea();

                int legajo3 = controladorAnimal.ingresarAnimal(true, (float) 2.0, (float) 3.0, 3, true, TipoAnimal.GATO,
                                "Luna");

                AnimalDTO animalEncontrado3 = controladorAnimal.obtenerAnimalDTO(legajo3);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "El animal " + animalEncontrado3.getNombre() + " fue cargado con el legajo: "
                                + animalEncontrado3.getLegajo() + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                int legajo4 = controladorAnimal.ingresarAnimal(false, (float) 2.0, (float) 3.0, 3, true, TipoAnimal.PERRO,
                                "Pinky");

                AnimalDTO animalEncontrado4 = controladorAnimal.obtenerAnimalDTO(legajo4);

                System.out.println(ConsoleColors.GREEN_BACKGROUND + "El animal " + animalEncontrado4.getNombre() + " fue cargado con el legajo: "
                                + animalEncontrado4.getLegajo() + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                
                controladorAdopcion.crearAdopcion(legajo4, clienteEncontrado.getEmail(),
                                "Quiero una mascota en tratamiento", "lumolina@uade.edu.ar");
                // Cargar tratamiento al animal 3

                int numeroDeTratamiento = controladorFichaMedica.crearTratamiento("Vacuna", "Vacuna contra la rabia",
                                new Date(), new Date(), legajo3);

                Escaner.getInstancia().proxLinea();
                // adoptar animal 3 en tratamiento

                controladorAdopcion.crearAdopcion(legajo3, clienteEncontrado.getEmail(),
                                "Quiero una mascota en tratamiento", "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // Finalizar el tratamiento del animal 3
                controladorFichaMedica.finalizarTratamiento(legajo3, numeroDeTratamiento);

                // Ahora que esta sano , adoptamos !

                Escaner.getInstancia().proxLinea();

                //Adoptamos a Luna
                int numeroAdopcion1 = controladorAdopcion.crearAdopcion(legajo3, clienteEncontrado.getEmail(),
                                "Quiero una mascota en tratamiento", "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // Intento adoptar el mismo animal
                //Intento volver a adoptar a Luna
                controladorAdopcion.crearAdopcion(legajo3, clienteEncontrado.getEmail(),
                                "Quiero una mascota en tratamiento", "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // adopto hasta 3 animales y NO me deja , solo adopta 2.
                //Adopto a Panchito
                int numeroAdopcion3 = controladorAdopcion.crearAdopcion(legajo2, clienteEncontrado.getEmail(),
                                "Quiero ", "lumolina@uade.edu.ar");

                //Intento Adoptar a Shona
                controladorAdopcion.crearAdopcion(legajo, clienteEncontrado.getEmail(), "Quiero ",
                                "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // Crear una alarma de tratamiento para el animal 3
                Duration preriodicidad = Duration.ofDays(1);
                int numeroAlarmaTratamiento = controladorAlarma.crearAlarma(preriodicidad, legajo3, numeroDeTratamiento);

                controladorAlarma.enviarNotificacion(numeroAlarmaTratamiento);

                Escaner.getInstancia().proxLinea();

                AlarmaDTO alarmaDTO = controladorAlarma.obtenerAlarmaDTO(numeroAlarmaTratamiento);
                alarmaDTO.printAcciones();

                Escaner.getInstancia().proxLinea();

                //atender alarma de tratamiento 
                controladorAlarma.atenderAlarma(alarmaDTO.getNumeroAlarma(), "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                controladorAlarma.atenderAlarma(alarmaDTO.getNumeroAlarma(), "lumolina@uade.edu.ar");

                Escaner.getInstancia().proxLinea();

                // Crear una alarma de control para el animal 2
                Duration periodicidad = Duration.ofDays(1);
                int numeroAlarmaControl = controladorAlarma.crearAlarma(periodicidad, legajo3);
                AlarmaDTO alarmaControlDTO = controladorAlarma.obtenerAlarmaDTO(numeroAlarmaControl);

                controladorAlarma.enviarNotificacion(numeroAlarmaTratamiento);

                Escaner.getInstancia().proxLinea();

                // atender alarma de control
                controladorAlarma.atenderAlarma(alarmaControlDTO.getNumeroAlarma(), "lumolina@uade.edu.ar");    
                controladorAlarma.atenderAlarma(alarmaControlDTO.getNumeroAlarma(), "lumolina@uade.edu.ar");
                
                Escaner.getInstancia().proxLinea();

                // adoptar un animal
                // int numeroAdopcion9 = controladorAdopcion.crearAdopcion(legajo,
                // clienteEncontrado.getEmail(),"Por que quiero una mascota",
                // "lumolina@uade.edu.ar");
                AdopcionDTO adopcionEncontrada = controladorAdopcion.buscarAdopcionDTO(numeroAdopcion3);

                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Se cargo la adopcion del animal " + adopcionEncontrada.getAnimalDTO().getNombre() 
                                + " del cliente: " + adopcionEncontrada.getClienteDTO().getNombre() + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                // adoptar segundo animal

                /*
                 * int numeroAdopcion5 = controladorAdopcion.crearAdopcion(legajo2,
                 * clienteEncontrado.getEmail(),
                 * "Por que quiero otra mascota", "lumolina@uade.edu.ar");
                 */
                AdopcionDTO adopcionEncontrada2 = controladorAdopcion.buscarAdopcionDTO(numeroAdopcion1);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Se cargo la adopcion del animal " + adopcionEncontrada2.getAnimalDTO().getNombre()
                                + " del cliente: " + adopcionEncontrada2.getClienteDTO().getNombre() + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                // Creo un seguimiento para el animal

                int numeroSeguimiento = controladorSeguimiento
                                .agregarSeguimientoAnimal(adopcionEncontrada.getNumeroAdopcion());
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Se agrego el seguimiento de la adopcion " 
                                + numeroSeguimiento + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                // enviar una notificacion
                RecordatorioDTO recordatorio = controladorAdopcion.enviarNotificacion(numeroAdopcion3);
                System.out.println(ConsoleColors.GREEN_BACKGROUND + "Recordatorio creado para destinatario: "
                                + recordatorio.getDestinatario().getNombre() + ConsoleColors.RESET);

                Escaner.getInstancia().proxLinea();

                // crear una visita y una encuesta posterior

                controladorSeguimiento.agregarVisita(numeroSeguimiento,
                                "El animal está mejorando.", Calificacion.BUENO, Calificacion.MALO,
                                Calificacion.REGULAR);

                Escaner.getInstancia().proxLinea();

                controladorSeguimiento.agregarVisita(numeroSeguimiento,
                                "El animal está mal.", Calificacion.MALO, Calificacion.MALO, Calificacion.REGULAR);
                // exportar ficha medica en ambos formatos

                FichaMedicaDTO fichaMedicaDTO1 = controladorFichaMedica.obtenerFichaMedicaDTO(legajo);
                FichaMedicaDTO fichaMedicaDTO2 = controladorFichaMedica.obtenerFichaMedicaDTO(legajo2);
                
                Escaner.getInstancia().proxLinea();

                controladorFichaMedica.cambiarEstrategiaExportacion(TipoExportacion.EXCEL, fichaMedicaDTO1.getLegajo());
                controladorFichaMedica.exportarFichaMedica(fichaMedicaDTO1.getLegajo());
                
                Escaner.getInstancia().proxLinea();

                controladorFichaMedica.cambiarEstrategiaExportacion(TipoExportacion.PDF, fichaMedicaDTO1.getLegajo());
                controladorFichaMedica.exportarFichaMedica(fichaMedicaDTO2.getLegajo());

                Escaner.getInstancia().proxLinea();

                //finalizar un seguimiento

                controladorSeguimiento.finalizarSeguimiento(numeroSeguimiento);

                controladorScanner.cerrarScanner();

               
        }
}
