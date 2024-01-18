package inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<String> nombreProductos = new ArrayList<>();
    static List<Double> precioProductos = new ArrayList<>();
    static List<Integer> stockProductos = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    ==========================================
                    MENÚ:
                    1 -> Listar Productos.
                    2 -> Agregar un Producto.
                    3 -> Buscar Producto.
                    4 -> Actualizar Producto.
                    5 -> Eliminar Producto.
                    6 -> Salir.
                    ==========================================""");
            System.out.print("Opción: ");
            int option = sc.nextInt();
            sc.nextLine(); // Arreglar el Buffer del Scanner.
            System.out.println("==========================================");

            switch (option) {
                // Listar Productos.
                case 1 -> {
                    if (nombreProductos.size() == 0) {
                        System.out.println("NO HAY PRODUTOS EN EL SISTEMA");
                    }
                    for (int i = 0; i < nombreProductos.size(); i++) {
                        imprimirProducto(i);
                    }
                }
                // Agregar un Producto.
                case 2 -> {
                    System.out.println("Agrega los datos del producto:");

                    System.out.print("\tNombre: ");
                    nombreProductos.add(sc.nextLine());

                    System.out.print("\tPrecio: ");
                    precioProductos.add(sc.nextDouble());

                    System.out.print("\tStock: ");
                    stockProductos.add(sc.nextInt());
                }
                // Buscar Producto.
                case 3 -> {
                    buscarProducto();
                }
                // Actualizar Producto.
                case 4 -> {
                    int i = buscarProducto();
                    // Salimos de la opcion si no ecuentra el producto.
                    if (i == -1) {
                        break;
                    }
                    // Solicitamos confirmacion del usuario. Si contesta algo distinto a 'y' o 'Y'
                    // lo tomaremos como un no.
                    System.out.println("==========================================");
                    System.out.println("Es este el producto que deseas actualizar? (y/n)");
                    String isCorrect = sc.nextLine();
                    if (isCorrect.toLowerCase().charAt(0) == 'y') {
                        System.out.println("Actualizar el producto nº " + i + ":");

                        System.out.print("\tNombre: ");
                        nombreProductos.set(i, sc.nextLine());

                        System.out.print("\tPrecio: ");
                        precioProductos.set(i, sc.nextDouble());

                        System.out.print("\tStock: ");
                        stockProductos.set(i, sc.nextInt());
                    }

                }
                // Eliminar Producto.
                case 5 -> {
                    int i = buscarProducto();
                    // Salimos de la opcion si no ecuentra el producto.
                    if (i == -1) {
                        break;
                    }
                    // Solicitamos confirmacion del usuario. Si contesta algo distinto a 'y' o 'Y'
                    // lo tomaremos como un no.
                    System.out.println("==========================================");
                    System.out.println("Es este el producto que deseas eliminar? (y/n)");
                    String isCorrect = sc.nextLine();
                    if (isCorrect.toLowerCase().charAt(0) == 'y') {
                        nombreProductos.remove(i);
                        precioProductos.remove(i);
                        stockProductos.remove(i);
                    }
                }
                // Salir.
                case 6 -> {
                    System.out.println("Saliendo del programa");
                    System.exit(0); // Salimos directamente del programa con codigo de error 0.
                }

                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    static void imprimirProducto(int i) {
        System.out.println("Producto nº " + i + ":");
        System.out.println("\tNombre: " + nombreProductos.get(i));
        System.out.println("\tPrecio: " + precioProductos.get(i) + "€");
        System.out.println("\tStock: " + stockProductos.get(i) + " unidades.");
    }

    static int buscarProducto() {
        System.out.print("Introduce el indice, nombre o porción del nombre del producto a buscar: ");
        String nombre = sc.nextLine();
        // Si el usuario introduce el indice del Producto.
        if (nombre.matches("\\d+")) {
            int i = Integer.parseInt(nombre);
            imprimirProducto(i);
            return i;
        }
        // Si el usuario introduce el nombre del Producto.
        for (int i = 0; i < nombreProductos.size(); i++) {
            if (nombreProductos.get(i).contains(nombre)) {
                imprimirProducto(i);
                return i;
            }
        }
        // Si no lo encuentra devuelve un -1;
        System.out.println("El producto introducido no coincide con ninguno de nuestra lista.");
        return -1;
    }
}