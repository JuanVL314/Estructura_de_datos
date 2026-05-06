import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private String nombre;
    private String email;
    private int semestre;

    private Double[][] notas = new Double[10][20];

    public Estudiante() {}

    public Estudiante(String id, String nombre, String email, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.semestre = semestre;
    }

    public double promedioSemestre(int sem) {
        double suma = 0;
        int count = 0;

        for (int i = 0; i < 20; i++) {
            if (notas[sem][i] != null) {
                suma += notas[sem][i];
                count++;
            }
        }
        return count == 0 ? 0 : suma / count;
    }

    public double promedioTotal() {
        double suma = 0;
        int count = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    suma += notas[i][j];
                    count++;
                }
            }
        }
        return count == 0 ? 0 : suma / count;
    }

    // getters y setters
}