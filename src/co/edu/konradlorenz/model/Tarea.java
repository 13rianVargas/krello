package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Tarea {
    private String descripcion;
    private String fechaVencimiento;
    private boolean casilla;
    private ArrayList<Colaborador> listaDelegados = new ArrayList<>();
    
    public Tarea() {
    }

    public Tarea(String descripcion, String fechaVencimiento, boolean casilla, ArrayList<Colaborador> listaDelegados) {
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

    public ArrayList<Colaborador> getListaDelegados() {
        return listaDelegados;
    }

    public void setListaDelegados(ArrayList<Colaborador> listaDelegados) {
        this.listaDelegados = listaDelegados;
    }

    @Override
    public String toString() {
        return "Tarea [descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento + ", casilla=" + casilla
                + ", listaDelegados=" + listaDelegados + "]";
    }

}
