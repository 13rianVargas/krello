package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Lista {
    private String nombreLista;
    private ArrayList<Lista> listaDeTareas = new ArrayList<>();
    
    public Lista() {
    }
    
    public Lista(String nombreLista, ArrayList<Lista> listaDeTareas) {
        this.nombreLista = nombreLista;
        this.listaDeTareas = listaDeTareas;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public ArrayList<Lista> getListaDeTareas() {
        return listaDeTareas;
    }

    public void setListaDeTareas(ArrayList<Lista> listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }

    @Override
    public String toString() {
        return "Lista [nombreLista=" + nombreLista + ", listaDeTareas=" + listaDeTareas + "]";
    }
    
}
