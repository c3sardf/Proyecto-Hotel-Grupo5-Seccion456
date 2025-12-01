package modelo;

public class Habitacion {
    private int numero;       
    private String tipo;      
    private int capacidad;    
    private double precio;
    private String estado;    

    public Habitacion(int numero, String tipo, int capacidad, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.estado = "Disponible"; 
    }

    
    public int getNumero() { return numero; } 
    public void setNumero(int numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}