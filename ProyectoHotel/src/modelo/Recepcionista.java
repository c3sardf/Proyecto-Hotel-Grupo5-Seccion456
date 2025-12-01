package modelo;

public class Recepcionista extends Empleado {
    public Recepcionista(String dni, String nombre, String apellido, String password) {
        super(dni, nombre, apellido, password);
    }

    @Override
    public String obtenerRol() { //Polimorfismo
        return "Recepcionista";
    }
}