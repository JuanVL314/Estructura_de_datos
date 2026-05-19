import java.io.BufferedReader;
import java.io.FileReader;

public class ProcesadorCSV {

        public void procesar(
                        String ruta,
                        EstudianteService estudianteService,
                        Materia materia) {

                try {

                        BufferedReader br = new BufferedReader(
                                        new FileReader(ruta));

                        String linea;
                        int creadosAutomaticos = 0;

                        while ((linea = br.readLine()) != null) {

                                String[] datos = linea.split(";");

                                if (datos.length < 2) {

                                        System.out.println(
                                                        "Linea invalida: " + linea);

                                        continue;
                                }

                                String id = datos[0].trim();

                                String codigo = datos[1].trim();

                                // Saltar encabezado
                                if (id.equalsIgnoreCase("ID Estudiante")) {

                                        continue;
                                }

                                // Validar materia
                                if (!materia.getCodigo().equals(codigo)) {

                                        System.out.println(
                                                        "Materia invalida: " + codigo);

                                        continue;
                                }

                                // Buscar estudiante
                                Estudiante estudiante = estudianteService.buscar(id);

                                // Crear automatico
                                if (estudiante == null &&
                                                creadosAutomaticos < 3) {

                                        estudiante = new Estudiante(
                                                        "Estudiante " + id,
                                                        id,
                                                        id + "@correo.com",
                                                        1);

                                        estudianteService.registrar(
                                                        estudiante);

                                        creadosAutomaticos++;

                                        System.out.println(
                                                        "Estudiante creado automaticamente: "
                                                                        + id);
                                }

                                // Si no existe
                                if (estudiante == null) {

                                        System.out.println(
                                                        "Estudiante no encontrado: "
                                                                        + id);

                                        continue;
                                }

                                // Inscribir
                                materia.inscribir(estudiante);
                        }
                        br.close();

                        System.out.println("Procesamiento CSV finalizado");

                } catch (Exception e) {

                        System.out.println("Error leyendo CSV: " + e.getMessage());
                }
        }
}