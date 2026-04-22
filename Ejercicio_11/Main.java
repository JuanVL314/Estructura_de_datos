import java.util.LinkedHashMap;
import java.util.LinkedList;

public static void main(String[] args) {
    LinkedList<String> historialNavegacion = new LinkedList<>();

    historialNavegacion.add("google.com");
    historialNavegacion.add("github.com");
    historialNavegacion.add("tackoverflow.com");

    System.err.println(historialNavegacion);

    System.out.println(historialNavegacion.getLast());
    
    historialNavegacion.removeLast();
    System.out.println(historialNavegacion);

    // --------------------------------------------------//

    Map<Integer, String> producto = new LinkedHashMap<>();
    producto.put(101, "laptop");
    producto.put(102, "Mause");
    producto.put(103, "teclado");

    System.out.println(producto);

    System.out.println(producto.containsKey(102));

    producto.put(101, "pantalla");

    System.out.println(producto);

    producto.forEach((key, value) -> {
    System.out.println("Codigo: [" + key + "] Producto: " + value);
    });


    Map<String, LinkedList<String>> pedidos = new HashMap<>();

    // Ana
    LinkedList<String> listaAna = new LinkedList<>();
    listaAna.add("Camisa");
    listaAna.add("Pantalón");
    pedidos.put("Ana", listaAna);

    // Luis
    LinkedList<String> listaLuis = new LinkedList<>();
    listaLuis.add("Zapatos");
    pedidos.put("Luis", listaLuis);

    // Cantidad de productos de Ana
    System.out.println("Productos de Ana: " + pedidos.get("Ana").size());

    // Agregar producto a Luis
    pedidos.get("Luis").add("Camisa");

    // Mostrar todo
    System.out.println(pedidos);
    



}
