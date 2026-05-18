import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {

    private String codigo;

    private String nombre;

    private int cuposMaximos;

    private int inscritos;

    private int creditos;

    private LinkedList<String> prerequisitos;

    private Queue<Estudiante> colaEspera;

    public Materia(
            String codigo,
            String nombre,
            int cuposMaximos,
            int creditos) {

        this.codigo = codigo;

        this.nombre = nombre;

        this.cuposMaximos = cuposMaximos;

        this.creditos = creditos;

        inscritos = 0;

        prerequisitos = new LinkedList<>();

        colaEspera = new ArrayDeque<>();
    }

    public void agregarPreRequisito(
            String materia) {

        prerequisitos.add(materia);
    }

    public boolean validarPreRequisitos(
            Estudiante estudiante) {

        for (String requisito :
                prerequisitos) {

            if (!estudiante.aproboMateria(
                    requisito)) {

                return false;
            }
        }

        return true;
    }

    public boolean hayCupos() {

        return inscritos < cuposMaximos;
    }

    public void inscribir(
            Estudiante estudiante) {

        if (!validarPreRequisitos(
                estudiante)) {

            System.out.println(
                    "No cumple prerequisitos");

            return;
        }

        if (hayCupos()) {

            inscritos++;

            estudiante.agregarMateriaHistorial(
                    codigo);

            System.out.println(
                    estudiante.getNombre()
                            + " inscrito correctamente");

        } else {

            colaEspera.offer(estudiante);

            System.out.println(
                    "Materia llena. Agregado a cola");
        }
    }

    public Queue<Estudiante> getColaEspera() {

        return colaEspera;
    }

    public String getCodigo() {

        return codigo;
    }
}