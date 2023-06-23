package modelos.dtos;

public class AccionDTO {

    private String nombre;
    private String descripcion;

    public AccionDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
