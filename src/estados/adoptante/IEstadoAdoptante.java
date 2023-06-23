package estados.adoptante;

import modelos.Animal;
import modelos.ClienteAdoptante;
import modelos.Adopcion;

public interface IEstadoAdoptante {

    public Adopcion adopcionAnimal(Animal animal, ClienteAdoptante clienteAdoptante, String motivoDeAdopcion);
}