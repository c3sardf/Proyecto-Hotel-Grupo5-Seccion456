package modelo;

public class ArregloServicios {
    private Servicio[] servicios;
    private int indice;

    public ArregloServicios() {
        this.servicios = new Servicio[50];
        this.indice = 0;
        
        //Datos de stock
        adicionar(new Servicio("Lavandería", 15.0));
        adicionar(new Servicio("Desayuno Americano", 25.0));
        adicionar(new Servicio("Frigobar - Bebida", 10.0));
        adicionar(new Servicio("Frigobar - Snack", 8.0));
        adicionar(new Servicio("Masaje Spa", 80.0));
        adicionar(new Servicio("Taxi Aeropuerto", 50.0));
    }

    public void adicionar(Servicio s) {
        if (indice < servicios.length) {
            servicios[indice] = s;
            indice++;
        }
    }

    public Servicio buscar(String nombre) {
        for (int i = 0; i < indice; i++) {
            if (servicios[i].getNombre().equalsIgnoreCase(nombre)) {
                return servicios[i];
            }
        }
        return null;
    }

    public void eliminar(String nombre) {
        for (int i = 0; i < indice; i++) {
            if (servicios[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < indice - 1; j++) {
                    servicios[j] = servicios[j + 1];
                }
                indice--;
                return;
            }
        }
    }

    public int tamano() { return indice; }
    public Servicio obtener(int i) { return servicios[i]; }
}
