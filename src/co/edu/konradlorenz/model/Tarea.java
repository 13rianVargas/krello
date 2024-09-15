package co.edu.konradlorenz.model;

public class Tarea {
    private String descripcion;
    private String fechaVencimiento;
    private boolean casilla;
    private Colaborador listaDelegados = new Colaborador();
    
    public Tarea() {
    }

    public Tarea(String descripcion, String fechaVencimiento, boolean casilla, Colaborador listaDelegados) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.casilla = casilla;
        this.listaDelegados = listaDelegados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isCasilla() {
        return casilla;
    }

    public void setCasilla(boolean casilla) {
        this.casilla = casilla;
    }

    public Colaborador getListaDelegados() {
        return listaDelegados;
    }

    public void setListaDelegados(Colaborador listaDelegados) {
        this.listaDelegados = listaDelegados;
    }

    @Override
    public String toString() {
        return "Tarea [descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento + ", casilla=" + casilla
                + ", listaDelegados=" + listaDelegados + "]";
    }

}
