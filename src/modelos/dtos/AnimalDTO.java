package modelos.dtos;

import enums.TipoAnimal;


public class AnimalDTO {

    private Boolean domestico;
    private Float altura;
    private Float peso;
    private int edad;
    private Boolean estadoSaludableAnimal;
    private TipoAnimal tipoDeAnimal;
    private String nombre;
    private int legajo;
    private FichaMedicaDTO fichaMedicaDTO;

    public AnimalDTO(Boolean domestico, Float altura, Float peso, int edad, Boolean estadoSaludableAnimal, TipoAnimal tipoDeAnimal, String nombre, int legajo, FichaMedicaDTO fichaMedica) {
        this.domestico = domestico;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.estadoSaludableAnimal = estadoSaludableAnimal;
        this.tipoDeAnimal = tipoDeAnimal;
        this.nombre = nombre;
        this.legajo = legajo;
        this.fichaMedicaDTO = fichaMedica;
    }

    public void setDomestico(Boolean domestico) {
        this.domestico = domestico;
    }

    public Boolean getDomestico() {
        return this.domestico;
    }
        
    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getAltura() {
        return this.altura;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
    
    public Float getPeso() {
        return this.peso;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEstadoSaludableAnimal(Boolean estadoSaludableAnimal) {
        this.estadoSaludableAnimal = estadoSaludableAnimal;
    }

    public Boolean getEstadoSaludableAnimal() {
        return this.estadoSaludableAnimal;
    }

    public void setTipoDeAnimal(TipoAnimal tipoDeAnimal) {
        this.tipoDeAnimal = tipoDeAnimal;
    }

    public TipoAnimal getTipoDeAnimal() {
        return this.tipoDeAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getLegajo() {
        return this.legajo;
    }

    public void setFichaMedica(FichaMedicaDTO fichaMedica) {
        this.fichaMedicaDTO = fichaMedica;
    }

    public FichaMedicaDTO getFichaMedica() {
        return this.fichaMedicaDTO;
    }

}