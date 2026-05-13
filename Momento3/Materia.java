
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {

    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int inscritos;
    private int creditos;

    // LISTA ENLAZADA
    private LinkedList<String> prerequisitos;

    // COLA
    private Queue<Estudiante> colaEspera;

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.creditos = creditos;

        inscritos = 0;

        prerequisitos = new LinkedList<>();

        colaEspera = new ArrayDeque<>();

    }

    // Agregar prerequisito
    public void agregarPreRequisito(String materia) {

        prerequisitos.add(materia);

    }

    // Verificar cupos
    public boolean hayCupos() {

        return inscritos < cuposMaximos;

    }

    // Inscribir estudiante
    public void inscribir(Estudiante estudiante) {

        if (hayCupos()) {

            inscritos++;

            System.out.println(estudiante.getNombre() + " inscrito correctamente");

        } else {

            colaEspera.offer(estudiante);

            System.out.println("Materia llena. " + estudiante.getNombre() + " agregado a cola");
        }
    }

    // Liberar cupo
    public void liberarCupo() {

        inscritos--;

        // Si hay estudiantes esperando
        if (!colaEspera.isEmpty()) {

            Estudiante siguiente = colaEspera.poll();

            inscritos++;

            System.out.println("Cupo asignado a " + siguiente.getNombre());

        }
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public LinkedList<String> getPrerequisitos() {
        return prerequisitos;
    }

    public String getCodigo() {
        return codigo;
    }
}