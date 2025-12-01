package modelo;

public class Administrador extends Empleado {
    public Administrador(String dni, String nombre, String apellido, String password) {
        super(dni, nombre, apellido, password);
    }

    @Override
    public String obtenerRol() { // Polimorfismo
        return "Administrador";
    }
}