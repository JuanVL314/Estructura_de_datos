import java.util.ArrayList;

public class NavegadorReportes {

    private ArrayList<String> reportes;

    private int indiceActual;

    public NavegadorReportes() {

        reportes = new ArrayList<>();

        indiceActual = -1;
    }

    // Agregar reporte
    public void agregarReporte(
            String reporte) {

        reportes.add(reporte);

        indiceActual =
                reportes.size() - 1;
    }

    // Mostrar actual
    public void mostrarActual() {

        if (reportes.isEmpty()) {

            System.out.println(
                    "No hay reportes");

            return;
        }

        System.out.println(
                "\n=== REPORTE ACTUAL ===");

        System.out.println(
                reportes.get(indiceActual));
    }

    // Ir atras
    public void atras() {

        if (indiceActual > 0) {

            indiceActual--;

            System.out.println(
                    "\n=== REPORTE ANTERIOR ===");

            System.out.println(
                    reportes.get(indiceActual));

        } else {

            System.out.println(
                    "No hay reportes anteriores");
        }
    }

    // Ir adelante
    public void adelante() {

        if (indiceActual <
                reportes.size() - 1) {

            indiceActual++;

            System.out.println(
                    "\n=== REPORTE SIGUIENTE ===");

            System.out.println(
                    reportes.get(indiceActual));

        } else {

            System.out.println(
                    "No hay mas reportes");
        }
    }
}