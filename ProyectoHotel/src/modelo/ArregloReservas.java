package modelo;

import java.time.LocalDate;

public class ArregloReservas {
    private Reserva[] reservas;
    private int indice;
    private int correlativo; //Para generar códigos 

    public ArregloReservas() {
        this.reservas = new Reserva[100];
        this.indice = 0;
        this.correlativo = 1;
    }

    public void adicionar(Reserva r) {
        if (indice < reservas.length) {
            reservas[indice] = r;
            indice++;
            correlativo++;
        }
    }
    
    
    public boolean verificarConflicto(Habitacion hab, LocalDate fInicio, LocalDate fFin) {
        for (int i = 0; i < indice; i++) {
            Reserva r = reservas[i];
            
            //verificamos si es la MISMA habitación
            if (r.getHabitacion().getNumero() == hab.getNumero()) {
                
                //verificamos si las fechas se cruzan 
                if (fInicio.isBefore(r.getFechaSalida()) && fFin.isAfter(r.getFechaEntrada())) {
                    return true; //Está ocupada
                }
            }
        }
        return false; //Está libre
    }
    
    //Generador de ID R-número de tres dígitos
    public String generarCodigo() {
        return "R-" + String.format("%03d", correlativo);
    }

    public int tamano() { return indice; }
    public Reserva obtener(int i) { return reservas[i]; }
    
    //método que usamos para buscar reserva por Código R-XXX
    public Reserva buscarPorId(String id) {
        for (int i = 0; i < indice; i++) {
            if (reservas[i].getIdReserva().equalsIgnoreCase(id)) {
                return reservas[i];
            }
        }
        return null;
        
    }
    //método para reporte de ingresos
    public double[] calcularIngresos(LocalDate fInicio, LocalDate fFin) {
        double sumaHabitacion = 0;
        double sumaServicios = 0;
        
        for (int i = 0; i < indice; i++) {
            Reserva r = reservas[i];
            
            //solo sumamos reservas que ya fueron PAGADAS
            if (r.getEstado().equals("Finalizada")) {
                
                //verificamos si la fecha de salida está dentro del rango solicitado
                LocalDate fechaPago = r.getFechaSalida();
                
                //(fechaPago >= fInicio) Y (fechaPago <= fFin)
                if ((fechaPago.isEqual(fInicio) || fechaPago.isAfter(fInicio)) &&
                    (fechaPago.isEqual(fFin) || fechaPago.isBefore(fFin))) {
                    
                    sumaHabitacion += r.getMontoTotal();
                    sumaServicios += r.getMontoServicios();
                }
            }
        }
        return new double[] { sumaHabitacion, sumaServicios };
    }
}