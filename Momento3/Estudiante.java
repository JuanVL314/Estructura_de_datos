import java.util.LinkedList;

public class Estudiante extends Persona {

    private int semestre;

    // MATRIZ NATIVA OBLIGATORIA
    private Double[][] notas;

    // LISTA ENLAZADA
    private LinkedList<String> historialMaterias;

    public Estudiante(String nombre, String id, String email, int semestre) {

        // Llama constructor padre
        super(nombre, id, email);

        this.semestre = semestre;

        // Creamos matriz 10x20
        notas = new Double[10][20];

        // Lista enlazada
        historialMaterias = new LinkedList<>();
    }

    // Sobrescritura (POLIMORFISMO)
    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Semestre: " + semestre);
    }

    // Registrar nota
    public void registrarNota(int semestre, int materia, Double nota) {

        notas[semestre][materia] = nota;

    }

    // Calcular promedio
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

    // Agregar materia al historial
    public void agregarMateriaHistorial(String materia) {

        historialMaterias.add(materia);
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    public Double[][] getNotas() {
        return notas;
    }
}