package modelo; 

public class Empleado {
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String password; 

    public Empleado(String dni, String nombre, String apellido, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    //getters y setters obligatorios
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //polimorfismo
    public String obtenerRol() {
        return "Generico";
    }
}
