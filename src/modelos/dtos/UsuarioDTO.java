package modelos.dtos;
import enums.TipoUsuario;

public class UsuarioDTO {
    
    private String nombre;
    private String email;
    private TipoUsuario tipoUsuario;
    private Boolean autenticacion;

    public UsuarioDTO(String nombre, String email, TipoUsuario tipoUsuario, Boolean autenticacion) {
        this.autenticacion = autenticacion;
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public Boolean getAutenticacion() {
        return autenticacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
