package modelos.dtos;

import java.util.ArrayList;

import enums.TipoNotificacion;
import enums.TipoAnimal;

public class ClienteAdoptanteDTO {
     
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String email;
    private String telefono;
    private String ocupacion;
    private ArrayList<TipoAnimal> tipoDeAnimalesInteresados;
    private Boolean otrasMascotas;
    private String motivoAdopcion;
    private TipoNotificacion tipoNotificacion;
    private int cantidadAdopciones;
    
    public ClienteAdoptanteDTO(String nombre, String apellido, String estadoCivil, String email, String telefono,String ocupacion,
    ArrayList<TipoAnimal> tipoDeAnimalesInteresados, Boolean otrasMascotas, TipoNotificacion tipoNotificacion, String motivoAdopcion, int cantidadAdopciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.tipoDeAnimalesInteresados = tipoDeAnimalesInteresados;
        this.otrasMascotas = otrasMascotas;
        this.motivoAdopcion = motivoAdopcion;
        this.tipoNotificacion = tipoNotificacion;
        this.cantidadAdopciones = cantidadAdopciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public ArrayList<TipoAnimal> getTipoDeAnimalesInteresados() {
        return tipoDeAnimalesInteresados;
    }

    public void setTipoDeAnimalesInteresados(ArrayList<TipoAnimal> tipoDeAnimalesInteresados) {
        this.tipoDeAnimalesInteresados = tipoDeAnimalesInteresados;
    }

    public Boolean getOtrasMascotas() {
        return otrasMascotas;
    }

    public void setOtrasMascotas(Boolean otrasMascotas) {
        this.otrasMascotas = otrasMascotas;
    }

    public String getMotivoAdopcion(){
        return motivoAdopcion;
    }

    public void setMotivoAdopcion(String motivoAdopcion){
        this.motivoAdopcion = motivoAdopcion;
    }

    public TipoNotificacion getTipoNotificacion(){
        return this.tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion){
        this.tipoNotificacion = tipoNotificacion;
    }

    public int getCantidadAdopciones(){
        return this.cantidadAdopciones;
    }

    public void setCantidadAdopciones(int cantidadAdopciones){
        this.cantidadAdopciones = cantidadAdopciones;
    }

}
