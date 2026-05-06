import java.util.*;

public class Materia {

    private String codigo;
    private String nombre;
    private int cuposMax;
    private int inscritos = 0;

    private LinkedList<String> prerequisitos = new LinkedList<>();
    private Queue<String> colaEspera = new LinkedList<>();
    private Set<String> estudiantesInscritos = new HashSet<>();

    public Materia(String codigo, String nombre, int cuposMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMax = cuposMax;
    }

    public void agregarPrerequisito(String cod) {
        prerequisitos.add(cod);
    }

    public void inscribir(String idEstudiante)
            throws CupoLlenoException {

        if (inscritos < cuposMax) {
            inscritos++;
            estudiantesInscritos.add(idEstudiante);
        } else {
            colaEspera.add(idEstudiante);
            throw new CupoLlenoException("Materia llena");
        }
    }

    public void cancelar(String idEstudiante) {
        if (estudiantesInscritos.remove(idEstudiante)) {
            inscritos--;

            if (!colaEspera.isEmpty()) {
                String siguiente = colaEspera.poll();
                estudiantesInscritos.add(siguiente);
                inscritos++;
                System.out.println("Cupo asignado a: " + siguiente);
            }
        }
    }

    // getters
}