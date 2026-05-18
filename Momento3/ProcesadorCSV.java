import java.io.BufferedReader;
import java.io.FileReader;

public class ProcesadorCSV {

    public void procesar(
            String ruta,
            EstudianteService estudianteService,
            Materia materia) {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(ruta)
                    );

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos =
                        linea.split(",");

                String id = datos[0];

                String codigo = datos[1];

                // Buscar estudiante
                Estudiante estudiante =
                        estudianteService.buscar(id);

                // Validar estudiante
                if (estudiante == null) {

                    System.out.println(
                            "Error estudiante no encontrado: "
                                    + id
                    );

                    continue;
                }

                // Validar materia
                if (!materia.getCodigo()
                        .equals(codigo)) {

                    System.out.println(
                            "Materia invalida: "
                                    + codigo
                    );

                    continue;
                }

                // Inscribir estudiante
                materia.inscribir(estudiante);
            }

            br.close();

            System.out.println(
                    "Procesamiento CSV finalizado"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error leyendo CSV: "
                            + e.getMessage()
            );
        }
    }
}