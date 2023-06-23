package estados.adoptante;

import modelos.Animal;
import modelos.ClienteAdoptante;
import modelos.Adopcion;
/**
 * 
 */
public class NoHabilitado implements IEstadoAdoptante {

    @Override
    public Adopcion adopcionAnimal(Animal animal, ClienteAdoptante clienteAdoptante, String motivoDeAdopcion) {
        return null;
    }

}