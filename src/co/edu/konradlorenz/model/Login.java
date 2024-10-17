package co.edu.konradlorenz.model;

public interface Login {

    public abstract boolean signUp(String correo, String password);

    public abstract boolean signIn(String correo, String password);

}
