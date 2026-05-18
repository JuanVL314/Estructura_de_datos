import java.util.Stack;

public class UndoRedoService {

    // PILAS
    private Stack<Operacion> pilaDeshacer;

    private Stack<Operacion> pilaRehacer;

    public UndoRedoService() {

        pilaDeshacer = new Stack<>();

        pilaRehacer = new Stack<>();
    }

    // GUARDAR OPERACION
    public void guardarOperacion(
            Operacion operacion) {

        pilaDeshacer.push(operacion);

        // Limpiar rehacer
        pilaRehacer.clear();
    }

    // DESHACER
    public void deshacer() {

        if (pilaDeshacer.isEmpty()) {

            System.out.println(
                    "Nada para deshacer"
            );

            return;
        }

        Operacion operacion =
                pilaDeshacer.pop();

        pilaRehacer.push(operacion);

        System.out.println(
                "Operacion deshecha: "
                        + operacion.getDescripcion()
        );
    }

    // REHACER
    public void rehacer() {

        if (pilaRehacer.isEmpty()) {

            System.out.println(
                    "Nada para rehacer"
            );

            return;
        }

        Operacion operacion =
                pilaRehacer.pop();

        pilaDeshacer.push(operacion);

        System.out.println(
                "Operacion rehecha: "
                        + operacion.getDescripcion()
        );
    }
}