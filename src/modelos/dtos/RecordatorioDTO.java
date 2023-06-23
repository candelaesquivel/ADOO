package modelos.dtos;

import java.util.*;

public class RecordatorioDTO {

    private ClienteAdoptanteDTO clienteAdoptanteDTO;
    private String mensaje;
    private Date fecha;
    
    public RecordatorioDTO(String mensaje, Date fecha, ClienteAdoptanteDTO clienteAdoptanteDTO) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.clienteAdoptanteDTO = clienteAdoptanteDTO;
    }
    public ClienteAdoptanteDTO getDestinatario() {
        return clienteAdoptanteDTO;
    }
    public String getMensaje() {
        return mensaje;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setDestinatario(ClienteAdoptanteDTO clienteAdoptanteDTO) {
        this.clienteAdoptanteDTO = clienteAdoptanteDTO;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}