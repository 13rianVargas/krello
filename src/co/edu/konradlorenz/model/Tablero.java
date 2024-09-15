package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Tablero {
    private String nombreTablero;
    private ArrayList<Lista> listaDeListas = new ArrayList<>();

    public Tablero() {
    }
    
    public Tablero(String nombreTablero, ArrayList<Lista> listaDeListas) {
        this.nombreTablero = nombreTablero;
        this.listaDeListas = listaDeListas;
    }

    public String getNombreTablero() {
        return nombreTablero;
    }

    public void setNombreTablero(String nombreTablero) {
        this.nombreTablero = nombreTablero;
    }

    public ArrayList<Lista> getListaDeListas() {
        return listaDeListas;
        }
        
    public void setListaDeListas(ArrayList<Lista> listaDeListas) {
        this.listaDeListas = listaDeListas;
    }
            
    @Override
    public String toString() {
        return "Tablero [nombreTablero=" + nombreTablero + ", listas=" + listaDeListas + "]";
    }
    
}