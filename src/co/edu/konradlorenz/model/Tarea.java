package co.edu.konradlorenz.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Tarea {
    private String descripcion;
    private LocalDateTime fechaVencimiento;
    private boolean casilla;
    private ArrayList<Persona> listaDelegados = new ArrayList<>();//lista heterogenea
    
    public Tarea() {
    }

    public Tarea(String descripcion, LocalDateTime fechaVencimiento, boolean casilla, ArrayList<Persona> listaDelegados) {
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

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
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
