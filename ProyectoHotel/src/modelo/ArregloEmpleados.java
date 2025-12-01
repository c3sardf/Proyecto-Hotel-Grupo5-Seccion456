package modelo;

public class ArregloEmpleados {
    private Empleado[] empleados;
    private int indice;

    public ArregloEmpleados() {
        this.empleados = new Empleado[50]; //tamaño fijo
        this.indice = 0;
        adicionar(new Administrador("admin", "Admin", "General", "12345")); //datos para el login
    }

    // Método Adicionar 
    public void adicionar(Empleado e) {
        if (indice < empleados.length) {
            empleados[indice] = e;
            indice++;
        }
    }

    //método Buscar
    public Empleado buscar(String dni) {
        for (int i = 0; i < indice; i++) {
            if (empleados[i].getDni().equals(dni)) {
                return empleados[i];
            }
        }
        return null;
    }
    
    //método Eliminar
    public void eliminar(String dni) {
        for (int i = 0; i < indice; i++) {
            if (empleados[i].getDni().equals(dni)) {
              
                for (int j = i; j < indice - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                indice--;
                return;
            }
        }
    }


    public int tamano() {
        return indice;
    }

    public Empleado obtener(int i) {
        return empleados[i];
    }
}
