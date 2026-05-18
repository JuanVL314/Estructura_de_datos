import java.util.Scanner;

public class MenuConsola {

        public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                EstudianteService estudianteService = new EstudianteService();

                UndoRedoService undoRedoService = new UndoRedoService();

                NavegadorReportes navegador = new NavegadorReportes();

                RutaService rutaService = new RutaService();

                ProcesadorCSV procesadorCSV = new ProcesadorCSV();

                Aula aula = new Aula("A101");

                Materia calculo = new Materia("CALC101", "Calculo I", 3, 4);

                int opcion;

                do {

                        System.out.println(
                                        "\n============================================================");

                        System.out.println(
                                        "PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");

                        System.out.println(
                                        "============================================================");

                        System.out.println(
                                        "=== GESTION DE ESTUDIANTES ===");

                        System.out.println(
                                        "1. Registrar estudiante");

                        System.out.println(
                                        "2. Buscar estudiante por ID");

                        System.out.println(
                                        "3. Listar todos los estudiantes");

                        System.out.println(
                                        "4. Eliminar estudiante");

                        System.out.println(
                                        "=== GESTION DE MATERIAS ===");

                        System.out.println(
                                        "5. Crear materia");

                        System.out.println(
                                        "6. Agregar pre-requisito");

                        System.out.println(
                                        "7. Mostrar pre-requisitos");

                        System.out.println(
                                        "8. Inscribir estudiante");

                        System.out.println(
                                        "9. Cancelar inscripcion");

                        System.out.println(
                                        "10. Mostrar cola de espera");

                        System.out.println(
                                        "=== GESTION DE HORARIOS ===");

                        System.out.println(
                                        "11. Reservar horario en aula");

                        System.out.println(
                                        "12. Liberar horario");

                        System.out.println(
                                        "13. Consultar disponibilidad");

                        System.out.println(
                                        "=== RUTAS ENTRE EDIFICIOS ===");

                        System.out.println(
                                        "14. Agregar conexion entre edificios");

                        System.out.println(
                                        "15. Calcular ruta mas corta");

                        System.out.println(
                                        "=== REPORTES ACADEMICOS ===");

                        System.out.println(
                                        "16. Registrar nota");

                        System.out.println(
                                        "17. Ver reporte academico");

                        System.out.println(
                                        "18. Navegador de reportes (atras/adelante)");

                        System.out.println(
                                        "=== SISTEMA DESHACER/REHACER ===");

                        System.out.println(
                                        "19. Deshacer ultima operacion");

                        System.out.println(
                                        "20. Rehacer ultima operacion");

                        System.out.println(
                                        "=== PROCESAMIENTO POR LOTES ===");

                        System.out.println(
                                        "21. Procesar archivo CSV");

                        System.out.println(
                                        "=== SALIR ===");

                        System.out.println(
                                        "22. Salir");

                        System.out.print(
                                        "Seleccione una opcion: ");

                        opcion = Integer.parseInt(sc.nextLine());

                        switch (opcion) {

                                case 1:

                                        System.out.print("ID: ");
                                        String id = sc.nextLine();

                                        System.out.print("Nombre: ");
                                        String nombre = sc.nextLine();

                                        System.out.print("Email: ");
                                        String email = sc.nextLine();

                                        System.out.print("Semestre: ");
                                        int semestre = Integer.parseInt(sc.nextLine());

                                        Estudiante estudiante = new Estudiante(nombre, id, email, semestre);

                                        estudianteService.registrar(estudiante);

                                        undoRedoService.guardarOperacion(
                                                        new Operacion("Registro estudiante " + nombre));

                                        System.out.println("Estudiante registrado");

                                        break;

                                case 2:

                                        System.out.print("Ingrese ID: ");

                                        String buscarId = sc.nextLine();

                                        Estudiante encontrado = estudianteService.buscar(buscarId);

                                        if (encontrado != null) {
                                                encontrado.mostrarInformacion();

                                        } else {

                                                System.out.println("No encontrado");

                                        }

                                        break;

                                case 3:

                                        estudianteService.listar();

                                        break;

                                case 4:

                                        System.out.println("Estudiante eliminado");

                                        break;

                                case 5:

                                        System.out.println("Materia creada");

                                        break;

                                case 6:

                                        System.out.print("Codigo prerequisito: ");

                                        String pre = sc.nextLine();

                                        calculo.agregarPreRequisito(pre);

                                        System.out.println("Pre-requisito agregado");

                                        break;

                                case 7:

                                        System.out.println("Pre-requisitos mostrados");

                                        break;

                                case 8:

                                        System.out.print("ID estudiante: ");

                                        String idInscripcion = sc.nextLine();

                                        Estudiante estudianteInscripcion = estudianteService.buscar(idInscripcion);

                                        if (estudianteInscripcion != null) {

                                                calculo.inscribir(estudianteInscripcion);

                                                undoRedoService.guardarOperacion(new Operacion(
                                                                "Inscripcion de " + estudianteInscripcion.getNombre()));

                                        } else {

                                                System.out.println("No encontrado");
                                        }

                                        break;

                                case 9:

                                        System.out.println("Inscripcion cancelada");

                                        break;

                                case 10:

                                        System.out.println("\n=== COLA DE ESPERA ===");

                                        for (Estudiante e : calculo.getColaEspera()) {

                                                System.out.println(e.getNombre());
                                        }

                                        break;

                                case 11:

                                        try {

                                                System.out.print("Dia (0-6): ");

                                                int dia = Integer.parseInt(sc.nextLine());

                                                System.out.print("Hora: ");

                                                int hora = Integer.parseInt(sc.nextLine());

                                                System.out.print("Duracion: ");

                                                int duracion = Integer.parseInt(sc.nextLine());

                                                aula.reservar(dia, hora, duracion);
                                                undoRedoService.guardarOperacion(new Operacion("Reserva aula"));

                                        } catch (Exception e) {

                                                System.out.println(e.getMessage());
                                        }

                                        break;

                                case 12:

                                        System.out.println("Horario liberado");

                                        break;

                                case 13:

                                        System.out.print("Dia: ");

                                        int diaConsulta = Integer.parseInt(sc.nextLine());

                                        System.out.print("Hora: ");

                                        int horaConsulta = Integer.parseInt(sc.nextLine());

                                        boolean disponible = aula.consultarDisponibilidad(diaConsulta, horaConsulta);

                                        if (disponible) {

                                                System.out.println("Horario libre");

                                        } else {

                                                System.out.println("Horario ocupado");

                                        }

                                        break;

                                case 14:

                                        System.out.println("\nEDIFICIOS:");

                                        System.out.println("0 = Ingenieria");
                                        System.out.println("1 = Biblioteca");
                                        System.out.println("2 = Cafeteria");
                                        System.out.println("3 = Rectoria");
                                        System.out.println("4 = Laboratorios");

                                        System.out.print("Origen: ");

                                        int origen = Integer.parseInt(sc.nextLine());

                                        System.out.print("Destino: ");

                                        int destino = Integer.parseInt(sc.nextLine());

                                        System.out.print("Distancia: ");

                                        int distancia = Integer.parseInt(sc.nextLine());

                                        rutaService.agregarConexion(origen, destino, distancia);

                                        System.out.println("Conexion agregada");

                                        break;
                                case 15:

                                        rutaService.dijkstra(0);

                                        break;

                                case 16:

                                        System.out.print("ID estudiante: ");

                                        String idNota = sc.nextLine();

                                        Estudiante estudianteNota = estudianteService.buscar(idNota);

                                        if (estudianteNota != null) {

                                                System.out.print("Semestre: ");

                                                int sem = Integer.parseInt(sc.nextLine());

                                                System.out.print("Nombre materia: ");

                                                String materiaNombre = sc.nextLine();

                                                System.out.print("Nota: ");

                                                double nota = Double.parseDouble(sc.nextLine());

                                                estudianteNota.registrarNota(sem, 0, nota);

                                                System.out.println("Nota registrada en " + materiaNombre);

                                        } else {

                                                System.out.println("Estudiante no encontrado");
                                        }

                                        break;
                                case 17:

                                        System.out.print("ID estudiante: ");

                                        String idReporte = sc.nextLine();

                                        Estudiante reporte = estudianteService.buscar(idReporte);

                                        if (reporte != null) {

                                                String textoReporte = "Estudiante: " + reporte.getNombre()
                                                                + "\nPromedio: " + reporte.calcularPromedio();

                                                navegador.agregarReporte(textoReporte);

                                                System.out.println("\n=== REPORTE ACADEMICO ===");

                                                System.out.println(textoReporte);

                                        } else {

                                                System.out.println("No encontrado");
                                        }

                                        break;

                                case 18:

                                        System.out.println("\n=== NAVEGADOR REPORTES ===");

                                        System.out.println("1. Ver actual");

                                        System.out.println("2. Atras");

                                        System.out.println("3. Adelante");

                                        System.out.print("Seleccione: ");

                                        int nav = Integer.parseInt(sc.nextLine());

                                        switch (nav) {

                                                case 1:

                                                        navegador.mostrarActual();

                                                        break;

                                                case 2:

                                                        navegador.atras();

                                                        break;

                                                case 3:

                                                        navegador.adelante();

                                                        break;

                                                default:

                                                        System.out.println("Opcion invalida");
                                        }

                                        break;

                                case 19:

                                        System.out.println("\n=== DESHACER OPERACION ===");

                                        undoRedoService.deshacer();

                                        break;

                                case 20:

                                        System.out.println("\n=== REHACER OPERACION ===");

                                        undoRedoService.rehacer();

                                        break;

                                case 21:

                                        java.io.File archivo = new java.io.File(
                                                        "./Datos/inscripciones.csv");

                                        System.out.println(
                                                        archivo.getAbsolutePath());

                                        System.out.println(
                                                        archivo.exists());

                                        procesadorCSV.procesar(
                                                        "./Datos/inscripciones.csv",
                                                        estudianteService,
                                                        calculo);

                                        break;

                                case 22:

                                        System.out.println("Saliendo...");

                                        break;

                                default:

                                        System.out.println("Opcion invalida");

                        }

                } while (opcion != 22);

                sc.close();
        }
}