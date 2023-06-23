package estrategias.accion;

import estados.alarma.IEstadoAccion;

public class Accion {

    private String nombre;
    private String descripcion;
    private IEstadoAccion estadoAccion;

    public Accion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.estadoAccion = new estados.alarma.Incompleta(); // por default esta en incompleta
        this.descripcion = descripcion;
    }

    public void atenderAccion() {// una vez completada , no puede volver a estar incompleta
        this.estadoAccion.atenderAccion(this);
    }

    public IEstadoAccion getEstadoAlarma() {
        return estadoAccion;
    }

    public void setEstadoAlarma(IEstadoAccion estadoAccion) {
        this.estadoAccion = estadoAccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getFinalizada() {
        return this.estadoAccion.getFinalizada();
    }
}
