package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    
    private String idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double montoTotal; //costo por alojamiento (dias*precio de habitación)
    private String estado;     // "Pendiente", "En Curso", "Finalizada", "Cancelada"

    //servicios adicionales
    private Consumo[] listaConsumos;
    private int indiceConsumo;

    //bob el constructor
    public Reserva(String idReserva, Huesped huesped, Habitacion habitacion, LocalDate fEntrada, LocalDate fSalida) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fEntrada;
        this.fechaSalida = fSalida;
        
        //estado inicial
        this.estado = "Pendiente"; 
        
        //calculo del costo de alojamiento
        long dias = ChronoUnit.DAYS.between(fEntrada, fSalida);
        if (dias < 1) dias = 1; // Mínimo se cobra 1 noche
        
        this.montoTotal = dias * habitacion.getPrecio();
        
        //inicializar el carrito de consumos
        this.listaConsumos = new Consumo[50];
        this.indiceConsumo = 0;
    }

    //métodos para gestionar consumos
    public void agregarConsumo(Consumo c) {
        if (indiceConsumo < listaConsumos.length) {
            listaConsumos[indiceConsumo] = c;
            indiceConsumo++;
        }
    }
    
    //obtener lista para mostrar en la tabla
    public Consumo[] getListaConsumos() {
        return listaConsumos;
    }
    
    //cuantos items ha pedido
    public int getCantidadConsumos() {
        return indiceConsumo;
    }
    
    //calcular cuanto debe solo por servicios extra
    public double getMontoServicios() {
        double suma = 0;
        for (int i = 0; i < indiceConsumo; i++) {
            suma += listaConsumos[i].getTotalLinea();
        }
        return suma;
    }
    
    //calcular cuenta final
    public double getMontoFinal() {
        return getMontoTotal() + getMontoServicios();
    }

    //getters y setters ps
    public String getIdReserva() { return idReserva; }
    
    public Huesped getHuesped() { return huesped; }
    
    public Habitacion getHabitacion() { return habitacion; }
    
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    
    public LocalDate getFechaSalida() { return fechaSalida; }
    
    public double getMontoTotal() { return montoTotal; } //Costo Habitación
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}