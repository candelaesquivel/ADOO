package modelos;


import java.util.*;

import enums.TipoNotificacion;
import estados.adoptante.IEstadoAdoptante;
import modelos.dtos.ClienteAdoptanteDTO;
import enums.TipoAnimal;
import estados.adoptante.Habilitado;

public class ClienteAdoptante {

    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String email;
    private String telefono;
    private String ocupacion;
    private ArrayList<TipoAnimal> tipoDeAnimalesInteresados;
    private Boolean otrasMascotas;
    private TipoNotificacion tipoNotificacion;
    private String motivoAdopcion;
    private int cantidadAdopciones;
    private IEstadoAdoptante estadoAdoptante;

    public  ClienteAdoptante( String nombre, String apellido, String estadoCivil, String email, String telefono, String ocupacion,
            ArrayList <TipoAnimal> tipoDeAnimalesInteresados, Boolean otrasMascotas, TipoNotificacion tipoNotificacion, String motivoAdopcion, int cantidadAdopciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.tipoDeAnimalesInteresados = tipoDeAnimalesInteresados;
        this.otrasMascotas =  otrasMascotas;
        this.tipoNotificacion = tipoNotificacion;
        this.motivoAdopcion = motivoAdopcion;
        this.cantidadAdopciones = cantidadAdopciones;
        this.estadoAdoptante = new Habilitado();
    }

    public Adopcion adopcionNueva(ClienteAdoptante cliente, Animal animal, String motivoAdopcion) {
        return estadoAdoptante.adopcionAnimal(animal, cliente, motivoAdopcion);
    }

    public void cambiarEstado(IEstadoAdoptante estadoAdoptante) {
        this.estadoAdoptante = estadoAdoptante;
    }
    
    public ClienteAdoptanteDTO toDTO() {
        return new ClienteAdoptanteDTO(this.nombre, this.apellido, this.estadoCivil, this.email, this.telefono, 
        this.ocupacion, this.tipoDeAnimalesInteresados, this.otrasMascotas, this.tipoNotificacion, this.motivoAdopcion, this.cantidadAdopciones);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setTipoDeAnimalesInteresados(ArrayList<TipoAnimal> tipoDeAnimalesInteresados) {
        this.tipoDeAnimalesInteresados = tipoDeAnimalesInteresados;
    }

    public void setotrasMascotas(Boolean otrasMascotas) {
        this.otrasMascotas = otrasMascotas;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public void setCantidadAdopciones(int cantidadAdopciones){
        this.cantidadAdopciones = cantidadAdopciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public ArrayList<TipoAnimal> getTipoDeAnimalesInteresados() {
        return this.tipoDeAnimalesInteresados;
    }

    public Boolean getotrasMascotas() {
        return this.otrasMascotas;
    }

    public TipoNotificacion getTipoNotificacion() {
        return this.tipoNotificacion;
    }

    public int getCantidadAdopciones(){
        return this.cantidadAdopciones;
    }

}