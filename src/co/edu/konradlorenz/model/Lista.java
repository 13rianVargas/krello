package co.edu.konradlorenz.model;

public class Lista {
    private String nombreLista;
    private Tarea listaDeTareas = new Tarea();
    
    public Lista() {
    }
    
    public Lista(String nombreLista, Tarea listaDeTareas) {
        this.nombreLista = nombreLista;
        this.listaDeTareas = listaDeTareas;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Tarea getListaDeTareas() {
        return listaDeTareas;
    }

    public void setListaDeTareas(Tarea listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }

    @Override
    public String toString() {
        return "Lista [nombreLista=" + nombreLista + ", listaDeTareas=" + listaDeTareas + "]";
    }
    
}
