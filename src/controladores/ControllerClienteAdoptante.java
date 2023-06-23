package controladores;

import java.util.*;
import modelos.*;
import modelos.dtos.ClienteAdoptanteDTO;
import enums.TipoAnimal;
import enums.TipoNotificacion;

public class ControllerClienteAdoptante{
    private ArrayList <ClienteAdoptante> clientes;
    private static ControllerClienteAdoptante instancia;

    public ControllerClienteAdoptante(){
        clientes = new ArrayList<ClienteAdoptante>();
    }

    public static ControllerClienteAdoptante getInstancia(){
        if (instancia == null)
            instancia = new ControllerClienteAdoptante();
        return instancia;
    }

    public void crearCliente(String nombre, String apellido, String estadoCivil, String email, String telefono, String ocupacion,
            ArrayList <TipoAnimal> tipoDeAnimalesInteresados, Boolean otrasMascotas, TipoNotificacion tipoNotificacion, String motivoAdopcion, int cantidadAdopciones) {
        ClienteAdoptante clienteAdoptante = new ClienteAdoptante( nombre,  apellido,  estadoCivil,  email,  telefono,  ocupacion,
            tipoDeAnimalesInteresados,  otrasMascotas,  tipoNotificacion,  motivoAdopcion,  cantidadAdopciones
         );
         
        this.clientes.add(clienteAdoptante);
    }

    protected ClienteAdoptante buscarClienteAdoptante(String email) {
        ClienteAdoptante clienteAdoptante = null;
        for (ClienteAdoptante cliente : clientes) {
            if (cliente.getEmail() == email){
                clienteAdoptante = cliente;
            }
        }
        return clienteAdoptante;
    }
    
    public ClienteAdoptanteDTO buscarClienteAdoptanteDTO(String email) {
        ClienteAdoptante clienteAdoptante = this.buscarClienteAdoptante(email);
        if(clienteAdoptante instanceof ClienteAdoptante){
            return clienteAdoptante.toDTO();
        }
        return null;
    }


}