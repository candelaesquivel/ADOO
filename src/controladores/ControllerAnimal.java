package controladores;

import java.util.*;

import enums.TipoAnimal;
import modelos.Animal;
import modelos.dtos.AnimalDTO;
import modelos.dtos.FichaMedicaDTO;

public class ControllerAnimal {

    private ArrayList<Animal> animales;
    private static ControllerAnimal instancia;

    private ControllerAnimal() {
        animales = new ArrayList<Animal>();
    }

    public static ControllerAnimal getInstancia() {
        if (instancia == null)
            instancia = new ControllerAnimal();
        return instancia;
    }

    public void ingresarAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal(
                animalDTO.getDomestico(),
                animalDTO.getAltura(),
                animalDTO.getPeso(),
                animalDTO.getEdad(),
                animalDTO.getEstadoSaludableAnimal(),
                animalDTO.getTipoDeAnimal(),
                animalDTO.getNombre());
        animales.add(animal);
    }

    public FichaMedicaDTO obtenerFichaMedica(int legajo) {
        Animal animal = obtenerAnimal(legajo);
        return animal.getFichaMedica().toDTO();
    }

    protected Animal obtenerAnimal(int legajo){
        for (Animal animal : animales)
            if (animal.getLegajo() == legajo){
                return animal;
            }
        return null;
    }

    public AnimalDTO obtenerAnimalDTO(int legajo) {
        Animal animal = this.obtenerAnimal(legajo);
        if (animal instanceof Animal) {
            return animal.toDTO();
        }
        return null;
    }

    public int ingresarAnimal(boolean domestico, Float altura, Float peso, int edad, boolean estadoAnimal,
            TipoAnimal tipoDeAnimal, String nombre) {
        Animal animal = new Animal(domestico, altura, peso, edad, estadoAnimal, tipoDeAnimal, nombre);
        animales.add(animal);
        ControllerFichaMedica.getInstancia().agregarFichaMedica(animal.getFichaMedica());
        return animal.getLegajo();
    }

    public void setEstadoSaludableAnimal(int legajo, boolean estadoSaludableAnimal) {
        Animal animal = this.obtenerAnimal(legajo);
        if (animal instanceof Animal) {
            animal.setEstadoSaludableAnimal(estadoSaludableAnimal);
        }
    }

}