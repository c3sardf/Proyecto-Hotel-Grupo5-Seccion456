package modelo;

public class ArregloHabitaciones {
    private Habitacion[] habitaciones;
    private int indice;

    public ArregloHabitaciones() {
        this.habitaciones = new Habitacion[100]; 
        this.indice = 0;
        
        //del piso 2 al 4 con habitacion del 1 al 4
        for (int piso = 2; piso <= 4; piso++) {
            for (int h = 1; h <= 4; h++) {
                
               
                
                int numero = (piso * 100) + h; 
                
                String tipo = "";
                double precio = 0.0;
                int capacidad = 0;

                switch (h) {
                    case 1: 
                        tipo = "Simple"; precio = 60.0; capacidad = 1; break;
                    case 2: 
                        tipo = "Matrimonial"; precio = 100.0; capacidad = 2; break;
                    case 3: 
                        tipo = "Doble"; precio = 130.0; capacidad = 2; break;
                    case 4: 
                        tipo = "Suite"; precio = 250.0; capacidad = 3; break;
                }
                
                adicionar(new Habitacion(numero, tipo, capacidad, precio));
            }
        }
    }

    public void adicionar(Habitacion h) {
        if (indice < habitaciones.length) {
            habitaciones[indice] = h;
            indice++;
        }
    }

    
    public Habitacion buscar(int numero) {
        for (int i = 0; i < indice; i++) {
            if (habitaciones[i].getNumero() == numero) { // Comparación numérica
                return habitaciones[i];
            }
        }
        return null; 
    }

    
    public void eliminar(int numero) {
        for (int i = 0; i < indice; i++) {
            if (habitaciones[i].getNumero() == numero) {
                for (int j = i; j < indice - 1; j++) {
                    habitaciones[j] = habitaciones[j + 1];
                }
                indice--; 
                return;
            }
        }
    }

    public int tamano() { return indice; }
    
    public Habitacion obtener(int i) { return habitaciones[i]; }
    
    public int contarPorTipo(String tipoBuscado) {
        int contador = 0;
        for (int i = 0; i < indice; i++) {
            if (habitaciones[i].getTipo().equals(tipoBuscado)) {
                contador++;
            }
        }
        return contador;
    }
}