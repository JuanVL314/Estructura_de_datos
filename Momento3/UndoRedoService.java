import java.util.Stack;

public class UndoRedoService {

    // PILAS OBLIGATORIAS
    private Stack<String> pilaDeshacer;
    private Stack<String> pilaRehacer;

    public UndoRedoService() {

        pilaDeshacer = new Stack<>();

        pilaRehacer = new Stack<>();
    }

    // Guardar operación
    public void guardarOperacion(String operacion) {

        pilaDeshacer.push(operacion);

    }

    // Deshacer
    public void deshacer() {

        if (pilaDeshacer.isEmpty()) {

            System.out.println("Nada para deshacer");

            return;
        }

        String operacion = pilaDeshacer.pop();

        pilaRehacer.push(operacion);

        System.out.println("Operación deshecha: " + operacion);

    }

    // Rehacer
    public void rehacer() {

        if (pilaRehacer.isEmpty()) {

            System.out.println("Nada para rehacer");

            return;
        }

        String operacion = pilaRehacer.pop();

        pilaDeshacer.push(operacion);

        System.out.println("Operación rehecha: " + operacion);

    }
}