import java.util.HashMap;

public class EstudianteService {

    // HASHMAP OBLIGATORIO
    private HashMap<String, Estudiante> estudiantes;

    public EstudianteService() {

        estudiantes = new HashMap<>();

    }

    // Registrar
    public void registrar(Estudiante estudiante) {

        estudiantes.put(estudiante.getId(), estudiante);

    }

    // Buscar
    public Estudiante buscar(String id) {

        return estudiantes.get(id);
    }

    // Eliminar
    public void eliminar(String id) {

        estudiantes.remove(id);
    }

    // Listar
    public void listar() {

        for (Estudiante e : estudiantes.values()) {
            e.mostrarInformacion();

            System.out.println("Promedio: " + e.calcularPromedio());

            System.out.println("----------------");
        }
    }
}