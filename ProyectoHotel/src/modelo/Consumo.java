package modelo;

public class Consumo {
    private String nombreServicio;
    private double precioUnitario;
    private int cantidad;
    private double totalLinea;

    public Consumo(String nombreServicio, double precioUnitario, int cantidad) {
        this.nombreServicio = nombreServicio;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.totalLinea = precioUnitario * cantidad;
    }

    //getters
    public String getNombreServicio() { return nombreServicio; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getCantidad() { return cantidad; }
    public double getTotalLinea() { return totalLinea; }
}