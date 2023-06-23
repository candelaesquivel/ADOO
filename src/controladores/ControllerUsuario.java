package controladores;

import java.util.*;
import modelos.Usuario;
import modelos.dtos.UsuarioDTO;
import enums.TipoUsuario;

public class ControllerUsuario {
    private ArrayList<Usuario> usuarios;
    private static ControllerUsuario instancia;

    private ControllerUsuario() {
        usuarios = new ArrayList<Usuario>();
    }

    public static ControllerUsuario getInstancia() {
        if (instancia == null)
            instancia = new ControllerUsuario();
        return instancia;
    }

    public String agregarUsuario(String email, String nombre, TipoUsuario tipoDeUsuario) {
        Usuario usuario = new Usuario(email, nombre, tipoDeUsuario);
        this.usuarios.add(usuario);
        return email;
    }

    public boolean autenticar(String email) throws Exception {
        Usuario usuario = buscarUsuario(email);
        if (usuario == null) {
            throw new Exception("Usuario inexistente");
        }
        return usuario.autenticarse();
    }

    protected Usuario buscarUsuario(String email) {
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getEmail() == email) {
                usuarioEncontrado = u;
            }
        }
        return usuarioEncontrado;
    }

    public UsuarioDTO buscarUsuarioDTO(String email) {
        Usuario usuario = this.buscarUsuario(email);
        return usuario.toDTO();
    }

}