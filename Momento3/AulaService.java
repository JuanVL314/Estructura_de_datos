import java.util.TreeMap;

public class AulaService {

    private TreeMap<String, Aula> aulas;

    public AulaService() {

        aulas = new TreeMap<>();
    }

    public void agregarAula(String nombre, Aula aula) {

        aulas.put(nombre, aula);
    }

    public void listarAulas() {

        for (String nombre : aulas.keySet()) {

            System.out.println(nombre);
        }
    }
}