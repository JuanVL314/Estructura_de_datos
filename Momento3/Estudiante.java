import java.util.LinkedList;

public class Estudiante extends Persona {

    private int semestre;

    private Double[][] notas;

    private LinkedList<String> historialMaterias;

    public Estudiante(String nombre, String id, String email, int semestre) {

        super(nombre, id, email);

        this.semestre = semestre;

        notas = new Double[10][20];

        historialMaterias = new LinkedList<>();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Semestre: " + semestre);
    }

    public void registrarNota(int semestre, int materia, Double nota) {

        notas[semestre][materia] = nota;
    }

    public double calcularPromedio() {

        double suma = 0;
        int contador = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 20; j++) {

                if (notas[i][j] != null) {

                    suma += notas[i][j];
                    contador++;
                }
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }
    
 public void agregarMateriaHistorial(String materia) {

        historialMaterias.add(materia);
    }

    public boolean aproboMateria(String codigo) {

        return historialMaterias.contains(codigo);
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }
}