import java.util.Scanner;

public class MenuConsola {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EstudianteService estudianteService = new EstudianteService();

        UndoRedoService undoRedoService = new UndoRedoService();

        RutaService rutaService = new RutaService();

        ProcesadorCSV procesadorCSV = new ProcesadorCSV();

        Aula aula = new Aula("101");

        Materia calculo = new Materia(
                "CALC101",
                "Calculo I",
                3,
                4);

        int opcion;

        do {

            System.out.println(
                    "\n===== SISTEMA UNIVERSITARIO =====");

            System.out.println(
                    "1. Registrar estudiante");

            System.out.println(
                    "2. Buscar estudiante");

            System.out.println(
                    "3. Listar estudiantes");

            System.out.println(
                    "4. Inscribir estudiante");

            System.out.println(
                    "5. Mostrar cola de espera");

            System.out.println(
                    "6. Reservar aula");

            System.out.println(
                    "7. Consultar disponibilidad");

            System.out.println(
                    "8. Ruta mas corta");

            System.out.println(
                    "9. Procesar CSV");

            System.out.println(
                    "10. Deshacer");

            System.out.println(
                    "11. Rehacer");

            System.out.println(
                    "12. Salir");

            System.out.print(
                    "Seleccione opcion: ");

            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                // ==========================
                // REGISTRAR ESTUDIANTE
                // ==========================

                case 1:

                    System.out.print("ID: ");

                    String id = sc.nextLine();

                    System.out.print("Nombre: ");

                    String nombre = sc.nextLine();

                    System.out.print("Email: ");

                    String email = sc.nextLine();

                    System.out.print("Semestre: ");

                    int semestre = sc.nextInt();

                    Estudiante estudiante = new Estudiante(
                            nombre,
                            id,
                            email,
                            semestre);

                    estudianteService
                            .registrar(estudiante);

                    undoRedoService
                            .guardarOperacion(
                                    new Operacion(
                                            "Registro estudiante"));

                    System.out.println(
                            "Estudiante registrado");

                    break;

                // ==========================
                // BUSCAR ESTUDIANTE
                // ==========================

                case 2:

                    System.out.print(
                            "Ingrese ID: ");

                    String buscarId = sc.nextLine();

                    Estudiante encontrado = estudianteService
                            .buscar(buscarId);

                    if (encontrado != null) {

                        encontrado
                                .mostrarInformacion();

                    } else {

                        System.out.println(
                                "No encontrado");
                    }

                    break;

                // ==========================
                // LISTAR
                // ==========================

                case 3:

                    estudianteService.listar();

                    break;

                // ==========================
                // INSCRIBIR
                // ==========================

                case 4:

                    System.out.print(
                            "ID estudiante: ");

                    String idInscripcion = sc.nextLine();

                    Estudiante estudianteInscripcion = estudianteService
                            .buscar(idInscripcion);

                    if (estudianteInscripcion != null) {

                        calculo.inscribir(
                                estudianteInscripcion);

                    } else {

                        System.out.println(
                                "No encontrado");
                    }

                    break;

                // ==========================
                // COLA DE ESPERA
                // ==========================

                case 5:

                    System.out.println(
                            "\n=== COLA DE ESPERA ===");

                    for (Estudiante e : calculo.getColaEspera()) {

                        System.out.println(
                                e.getNombre());
                    }

                    break;

                // ==========================
                // RESERVAR AULA
                // ==========================

                case 6:

                    try {

                        System.out.print(
                                "Dia: ");

                        int dia = sc.nextInt();

                        System.out.print(
                                "Hora: ");

                        int hora = sc.nextInt();

                        System.out.print(
                                "Duracion: ");

                        int duracion = sc.nextInt();

                        aula.reservar(
                                dia,
                                hora,
                                duracion);

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                // ==========================
                // CONSULTAR DISPONIBILIDAD
                // ==========================

                case 7:

                    System.out.print(
                            "Dia: ");

                    int diaConsulta = sc.nextInt();

                    System.out.print(
                            "Hora: ");

                    int horaConsulta = sc.nextInt();

                    boolean disponible = aula.consultarDisponibilidad(
                            diaConsulta,
                            horaConsulta);

                    if (disponible) {

                        System.out.println(
                                "Horario libre");

                    } else {

                        System.out.println(
                                "Horario ocupado");
                    }

                    break;

                // ==========================
                // RUTA MAS CORTA
                // ==========================

                case 8:

                    rutaService.agregarConexion(
                            0,
                            2,
                            150);

                    rutaService.agregarConexion(
                            2,
                            3,
                            180);

                    rutaService.dijkstra(0);

                    break;

                // ==========================
                // PROCESAR CSV
                // ==========================

                case 9:

                    procesadorCSV.procesar(
                            "data/inscripciones.csv",
                            estudianteService,
                            calculo);

                    break;

                // ==========================
                // DESHACER
                // ==========================

                case 10:

                    undoRedoService.deshacer();

                    break;

                // ==========================
                // REHACER
                // ==========================

                case 11:

                    undoRedoService.rehacer();

                    break;

                // ==========================
                // SALIR
                // ==========================

                case 12:

                    System.out.println(
                            "Saliendo...");

                    break;

                default:

                    System.out.println(
                            "Opcion invalida");
            }

        } while (opcion != 12);

        sc.close();
    }
}