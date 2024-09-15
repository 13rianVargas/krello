package co.edu.konradlorenz.model;

public class Tablero {
    private String nombreTablero;
    private Lista listaDeListas = new Lista();

    public Tablero() {
    }
    
    public Tablero(String nombreTablero, Lista listaDeListas) {
        this.nombreTablero = nombreTablero;
        this.listaDeListas = listaDeListas;
    }

    public String getNombreTablero() {
        return nombreTablero;
    }

    public void setNombreTablero(String nombreTablero) {
        this.nombreTablero = nombreTablero;
    }

    public Lista getListaDeListas() {
        return listaDeListas;
        }
        
    public void setListaDeListas(Lista listaDeListas) {
        this.listaDeListas = listaDeListas;
    }
            
    @Override
    public String toString() {
        return "Tablero [nombreTablero=" + nombreTablero + ", listas=" + listaDeListas + "]";
    }
    
}