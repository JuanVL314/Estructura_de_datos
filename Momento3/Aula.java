
public class Aula {

    private String nombre;

    // MATRIZ OBLIGATORIA
    private boolean[][] horarios;

    public Aula(String nombre) {

        this.nombre = nombre;

        horarios = new boolean[7][24];
    }

    // Reservar horario
    public void reservar(int dia, int hora, int duracion) throws HorarioConflictivoException {

        // Verificar disponibilidad
        for (int i = hora; i < hora + duracion; i++) {

            if (horarios[dia][i]) {

                throw new HorarioConflictivoException("Horario ocupado");

            }
        }

        // Reservar
        for (int i = hora; i < hora + duracion; i++) {

            horarios[dia][i] = true;
        }

        System.out.println("Reserva exitosa");
    }

    // Liberar horario
    public void liberar(int dia, int hora, int duracion) {

        for (int i = hora; i < hora + duracion; i++) {

            horarios[dia][i] = false;
        }
    }

    // Consultar disponibilidad
    public boolean consultarDisponibilidad( int dia, int hora) {

        return !horarios[dia][hora];
    }
}