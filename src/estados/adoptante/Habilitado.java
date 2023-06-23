package estados.adoptante;

import modelos.Adopcion;
import modelos.Animal;
import modelos.ClienteAdoptante;

/**
 * 
 */
public class Habilitado implements IEstadoAdoptante {

    @Override
    public Adopcion adopcionAnimal(Animal animal, ClienteAdoptante clienteAdoptante, String motivoDeAdopcion) {
        Adopcion adopcion = new Adopcion(
            animal,
            clienteAdoptante,
            motivoDeAdopcion);
        clienteAdoptante.setCantidadAdopciones(clienteAdoptante.getCantidadAdopciones() + 1);
        if (clienteAdoptante.getCantidadAdopciones() >= 2)
            clienteAdoptante.cambiarEstado(new NoHabilitado());
        return adopcion;
    }

}