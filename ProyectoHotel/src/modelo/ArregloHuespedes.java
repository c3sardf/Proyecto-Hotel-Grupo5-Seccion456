package modelo;

public class ArregloHuespedes {
    private Huesped[] huespedes;
    private int indice;

    public ArregloHuespedes() {
        this.huespedes = new Huesped[200]; // Capacidad para 200 clientes 
        this.indice = 0;
        
        //Clientes de prueba
        adicionar(new Huesped("10000001", "Carlos", "Sainz", "991112233"));
        adicionar(new Huesped("10000002", "Max", "Verstappen", "992223344"));
        adicionar(new Huesped("10000003", "Lewis", "Hamilton", "993334455"));
        adicionar(new Huesped("10000004", "Fernando", "Alonso", "994445566"));
        adicionar(new Huesped("10000005", "Sergio", "Perez", "995556677"));
    }

    
    public void adicionar(Huesped h) {
        if (indice < huespedes.length) {
            huespedes[indice] = h;
            indice++;
        }
    }

    public Huesped buscar(String dni) {
        for (int i = 0; i < indice; i++) {
            if (huespedes[i].getDni().equals(dni)) {
                return huespedes[i];
            }
        }
        return null;
    }

    public void eliminar(String dni) {
        for (int i = 0; i < indice; i++) {
            if (huespedes[i].getDni().equals(dni)) {
                for (int j = i; j < indice - 1; j++) {
                    huespedes[j] = huespedes[j + 1];
                }
                indice--;
                return;
            }
        }
    }

    public int tamano() { return indice; }
    public Huesped obtener(int i) { return huespedes[i]; }
}