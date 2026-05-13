import java.util.Scanner;

public class MenuConsola {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // SERVICIOS
        EstudianteService estudianteService = new EstudianteService();

        UndoRedoService undoRedoService = new UndoRedoService();

        RutaService rutaService = new RutaService();

        // OBJETOS DE PRUEBA
        Aula aula = new Aula("101");

        Materia calculo = new Materia("CALC101", "Calculo I", 3, 4);

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println(" SISTEMA UNIVERSITARIO ");
            System.out.println("=================================");

            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Crear materia");
            System.out.println("5. Inscribir estudiante");
            System.out.println("6. Mostrar cola espera");
            System.out.println("7. Reservar aula");
            System.out.println("8. Consultar disponibilidad");
            System.out.println("9. Agregar conexion edificios");
            System.out.println("10. Calcular rutas");
            System.out.println("11. Deshacer");
            System.out.println("12. Rehacer");
            System.out.println("13. Salir");

            System.out.print("Seleccione opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =====================================
                // REGISTRAR ESTUDIANTE
                // =====================================

                case 1:

                    System.out.println("\n--- REGISTRO ---");

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();

                    Estudiante estudiante = new Estudiante(nombre, id, email, semestre);

                    estudianteService.registrar(estudiante);

                    System.out.println("Estudiante registrado");

                    undoRedoService.guardarOperacion("Registro estudiante " + nombre);

                    break;

                // =====================================
                // BUSCAR ESTUDIANTE
                // =====================================

                case 2:

                    System.out.print("Ingrese ID: ");

                    String buscarId = sc.nextLine();

                    Estudiante encontrado = estudianteService.buscar(buscarId);

                    if (encontrado != null) {

                        encontrado.mostrarInformacion();

                    } else {

                        System.out.println("Estudiante no encontrado");

                    }

                    break;

                // =====================================
                // LISTAR
                // =====================================

                case 3:

                    estudianteService.listar();

                    break;

                // =====================================
                // CREAR MATERIA
                // =====================================

                case 4:

                    System.out.println("Materia creada: CALC101");

                    calculo.agregarPreRequisito("MAT001");

                    break;

                // =====================================
                // INSCRIBIR
                // =====================================

                case 5:

                    System.out.print("ID estudiante: ");

                    String idInscripcion = sc.nextLine();

                    Estudiante estudianteInscripcion = estudianteService.buscar(idInscripcion);

                    if (estudianteInscripcion != null) {

                        calculo.inscribir(estudianteInscripcion);

                        undoRedoService.guardarOperacion("Inscripcion " + estudianteInscripcion.getNombre());

                    } else {

                        System.out.println("No encontrado");
                    }

                    break;

                // =====================================
                // COLA ESPERA
                // =====================================

                case 6:

                    System.out.println("--- COLA ESPERA ---");

                    for (Estudiante e : calculo.getColaEspera()) {

                        System.out.println(e.getNombre());

                    }

                    break;

                // =====================================
                // RESERVAR AULA
                // =====================================

                case 7:

                    try {

                        System.out.print("Dia: ");
                        int dia = sc.nextInt();

                        System.out.print("Hora: ");
                        int hora = sc.nextInt();

                        System.out.print("Duracion: ");
                        int duracion = sc.nextInt();

                        aula.reservar (dia, hora, duracion);

                        undoRedoService.guardarOperacion("Reserva aula");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                // =====================================
                // CONSULTAR DISPONIBILIDAD
                // =====================================

                case 8:

                    System.out.print("Dia: ");
                    int diaConsulta = sc.nextInt();

                    System.out.print("Hora: ");
                    int horaConsulta = sc.nextInt();

                    boolean disponible = aula.consultarDisponibilidad(diaConsulta, horaConsulta);

                    if (disponible) {

                        System.out.println("Horario libre");

                    } else {

                        System.out.println("Horario ocupado");

                    }

                    break;

                // =====================================
                // AGREGAR CONEXION
                // =====================================

                case 9:

                    System.out.print("Origen: ");

                    int origen = sc.nextInt();

                    System.out.print("Destino: ");

                    int destino = sc.nextInt();

                    System.out.print("Distancia: ");

                    int distancia = sc.nextInt();

                    rutaService.agregarConexion(origen, destino, distancia);

                    System.out.println("Conexion agregada");

                    break;

                // =====================================
                // DIJKSTRA
                // =====================================

                case 10:

                    System.out.print("Origen: ");

                    int inicio = sc.nextInt();

                    rutaService.dijkstra(inicio);

                    break;

                // =====================================
                // DESHACER
                // =====================================

                case 11:

                    undoRedoService.deshacer();

                    break;

                // =====================================
                // REHACER
                // =====================================

                case 12:

                    undoRedoService.rehacer();

                    break;

                // =====================================
                // SALIR
                // =====================================

                case 13:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opcion invalida");

            }

        } while (opcion != 13);

        sc.close();
    }
}