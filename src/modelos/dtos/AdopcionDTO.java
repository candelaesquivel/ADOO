package modelos.dtos;

public class AdopcionDTO {

    private AnimalDTO animalDTO;
    private ClienteAdoptanteDTO clienteAdoptanteDTO;
    private int numeroAdopcion;
    private String motivoAdopcion;

    public AdopcionDTO(AnimalDTO animal, ClienteAdoptanteDTO cliente, int numeroAdopcion, String motivoAdopcion) {
        this.animalDTO = animal;
        this.clienteAdoptanteDTO = cliente;
        this.numeroAdopcion = numeroAdopcion;
        this.motivoAdopcion = motivoAdopcion;
    }

    public AnimalDTO getAnimalDTO() {
        return animalDTO;
    }

    public ClienteAdoptanteDTO getClienteDTO() {
        return clienteAdoptanteDTO;
    }

    public int getNumeroAdopcion() {
        return numeroAdopcion;
    }

    public String getMotivoAdopcion() {
        return motivoAdopcion;
    }

}
