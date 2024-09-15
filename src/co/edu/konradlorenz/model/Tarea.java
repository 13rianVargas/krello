package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Tarea {
    private String descripcion;
    private String fechaVencimiento;
    private boolean casilla;
    private ArrayList<Persona> listaDelegados = new ArrayList<>();//lista heterogenea
    
    public Tarea() {
    }

    public Tarea(String descripcion, String fechaVencimiento, boolean casilla, ArrayList<Persona> listaDelegados) {
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

    public ArrayList<Persona> getListaDelegados() {
        return listaDelegados;
    }

    public void setListaDelegados(ArrayList<Persona> listaDelegados) {
        this.listaDelegados = listaDelegados;
    }

    @Override
    public String toString() {
        return "Tarea [descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento + ", casilla=" + casilla
                + ", listaDelegados=" + listaDelegados + "]";
    }

}
