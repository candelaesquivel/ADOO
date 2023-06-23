package modelos;

import enums.TipoAnimal;
import modelos.dtos.AnimalDTO;

public class Animal {

    private static int contadorLegajo = 1;

    private Boolean domestico;
    private Float altura;
    private Float peso;
    private int edad;
    private Boolean estadoSaludableAnimal;
    private TipoAnimal tipoDeAnimal;
    private String nombre;
    private int legajo;
    private Boolean adoptado;
    private FichaMedica fichaMedica;

    public Animal(Boolean domestico, Float altura, Float peso, int edad, Boolean estadoSaludableAnimal,
            TipoAnimal tipoDeAnimal, String nombre) {
        this.domestico = domestico;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.estadoSaludableAnimal = estadoSaludableAnimal;
        this.tipoDeAnimal = tipoDeAnimal;
        this.legajo = contadorLegajo++;
        this.nombre = nombre;
        this.fichaMedica = new FichaMedica(this);
        this.adoptado = false;
    }

    public AnimalDTO toDTO() {
        return new AnimalDTO(this.domestico, this.altura, this.peso, this.edad, this.estadoSaludableAnimal,
                this.tipoDeAnimal,
                this.nombre, this.legajo, this.fichaMedica.toDTO());
    }

    public Boolean getDomestico() {
        return this.domestico;
    }

    public Float getAltura() {
        return this.altura;
    }

    public Float getPeso() {
        return this.peso;
    }

    public int getEdad() {
        return this.edad;
    }

    public Boolean getEstadoSaludableAnimal() {
        return this.estadoSaludableAnimal;
    }

    public TipoAnimal getTipoDeAnimal() {
        return this.tipoDeAnimal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getLegajo() {
        return this.legajo;
    }

    public FichaMedica getFichaMedica() {
        return this.fichaMedica;
    }

    public Boolean getAdoptado(){
        return this.adoptado;
    }

    public void setDomestico(Boolean domestico) {
        this.domestico = domestico;
    }

    public void setTipoDeAnimal(TipoAnimal tipoDeAnimal) {
        this.tipoDeAnimal = tipoDeAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setFichaMedica(FichaMedica fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoSaludableAnimal(Boolean estadoSaludableAnimal) {
        this.estadoSaludableAnimal = estadoSaludableAnimal;
    }
   
    public void setAdoptado(Boolean adoptado) {
        this.adoptado = adoptado;
    }
}