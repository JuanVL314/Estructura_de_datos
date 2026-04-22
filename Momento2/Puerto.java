import java.util.*;

public class Puerto {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        Contenedor[] manifiesto = new Contenedor[6];
        double pesoTotal = 0;

        System.out.println("=== REGISTRO DE MANIFIESTO ===");

        for (int i = 0; i < manifiesto.length; i++) {

            System.out.print("ID: ");
            String id = sc.next();

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            System.out.print("Prioridad: ");
            int prioridad = sc.nextInt();

            manifiesto[i] = new Contenedor(id, peso, prioridad);
            pesoTotal += peso;
        }

        System.out.println("Peso total: " + pesoTotal);


        Contenedor[][] patio = new Contenedor[3][3];

        for (Contenedor c : manifiesto) {
            if (!ubicarEnPatio(patio, c)) {
                System.out.println("⚠ Puerto Saturado");
            }
        }

        mostrarPatio(patio);


        Queue<Contenedor> inspeccion = new LinkedList<>();

        System.out.println("\n=== INSPECCIÓN ===");

        for (Contenedor c : manifiesto) {
            if (c.getPrioridad() >= 8) {
                inspeccion.add(c);
            }
        }

        while (!inspeccion.isEmpty()) {
            System.out.println("Inspeccionando: " + inspeccion.poll());
        }


        Stack<Contenedor> buque = new Stack<>();

        System.out.println("\n=== BUQUE ===");

        for (Contenedor c : manifiesto) {
            apilarConRegla(buque, c);
        }

        mostrarPila(buque);


        System.out.println("\n=== ELIMINAR FONDO ===");
        eliminarFondo(buque);

        mostrarPila(buque);
    }

    public static boolean ubicarEnPatio(Contenedor[][] patio, Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public static void mostrarPatio(Contenedor[][] patio) {
        System.out.println("\nPATIO:");
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] != null)
                    System.out.print(patio[i][j].getId() + "\t");
                else
                    System.out.print("NULL\t");
            }
            System.out.println();
        }
    }


    public static void apilarConRegla(Stack<Contenedor> pila, Contenedor c) {
        if (pila.isEmpty() || c.getPeso() <= pila.peek().getPeso()) {
            pila.push(c);
        } else {
            System.out.println("No se puede apilar: " + c);
        }
    }

    public static void mostrarPila(Stack<Contenedor> pila) {
        System.out.println("\nBUQUE:");
        for (Contenedor c : pila) {
            System.out.println(c);
        }
    }

    public static void eliminarFondo(Stack<Contenedor> pila) {
        Stack<Contenedor> aux = new Stack<>();

        while (!pila.isEmpty()) {
            aux.push(pila.pop());
        }

        if (!aux.isEmpty()) {
            System.out.println("Eliminado: " + aux.pop());
        }

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}