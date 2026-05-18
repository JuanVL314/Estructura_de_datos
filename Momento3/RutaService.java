import java.util.Arrays;

public class RutaService {

    // MATRIZ DE ADYACENCIA
    private int[][] grafo;

    // NOMBRES DE EDIFICIOS
    private String[] edificios;

    public RutaService() {

        edificios = new String[] {
                "Ingenieria",
                "Biblioteca",
                "Cafeteria",
                "Rectoria",
                "Laboratorios"
        };

        grafo = new int[5][5];
    }

    // AGREGAR CONEXION
    public void agregarConexion(
            int origen,
            int destino,
            int distancia) {

        grafo[origen][destino] = distancia;

        grafo[destino][origen] = distancia;
    }

    // ALGORITMO DIJKSTRA
    public void dijkstra(int origen) {

        int n = grafo.length;

        int[] distancia = new int[n];

        boolean[] visitado =
                new boolean[n];

        Arrays.fill(
                distancia,
                Integer.MAX_VALUE
        );

        distancia[origen] = 0;

        for (int i = 0; i < n - 1; i++) {

            int u = minimo(
                    distancia,
                    visitado
            );

            visitado[u] = true;

            for (int v = 0; v < n; v++) {

                if (!visitado[v]
                        && grafo[u][v] != 0
                        && distancia[u]
                        != Integer.MAX_VALUE
                        && distancia[u]
                        + grafo[u][v]
                        < distancia[v]) {

                    distancia[v] =
                            distancia[u]
                                    + grafo[u][v];
                }
            }
        }

        // MOSTRAR RESULTADOS

        System.out.println(
                "\n=== DISTANCIAS ==="
        );

        for (int i = 0; i < n; i++) {

            System.out.println(
                    edificios[i]
                            + ": "
                            + distancia[i]
                            + " metros"
            );
        }
    }

    // BUSCAR MENOR DISTANCIA
    private int minimo(
            int[] distancia,
            boolean[] visitado) {

        int min = Integer.MAX_VALUE;

        int indice = -1;

        for (int i = 0;
             i < distancia.length;
             i++) {

            if (!visitado[i]
                    && distancia[i] <= min) {

                min = distancia[i];

                indice = i;
            }
        }

        return indice;
    }
}