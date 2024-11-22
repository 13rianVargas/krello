package co.edu.konradlorenz.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {
    private String descripcion;
    private LocalDate fechaVencimiento;
    private boolean casilla;
    private ArrayList<Persona> listaDelegados;
    
    public Tarea() {
    }

    public Tarea(String descripcion, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.casilla = false;
        this.listaDelegados = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
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
