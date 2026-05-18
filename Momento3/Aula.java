public class Aula {

    private String nombre;

    private boolean[][] horarios;

    public Aula(String nombre) {

        this.nombre = nombre;

        horarios = new boolean[7][24];
    }

    public void reservar(
            int dia,
            int hora,
            int duracion)
            throws Exception {

        if (dia < 0 || dia > 6) {

            throw new Exception(
                    "Dia invalido");
        }

        if (hora < 0 ||
                hora + duracion > 24) {

            throw new Exception(
                    "Hora invalida");
        }

        for (int i = hora;
             i < hora + duracion;
             i++) {

            if (horarios[dia][i]) {

                throw new Exception(
                        "Horario ocupado");
            }
        }

        for (int i = hora;
             i < hora + duracion;
             i++) {

            horarios[dia][i] = true;
        }

        System.out.println(
                "Reserva exitosa");
    }

    public boolean consultarDisponibilidad(
            int dia,
            int hora) {

        return !horarios[dia][hora];
    }
}