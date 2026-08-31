/**
 * Clase principal del programa
 * Es la entrada al sistema.
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("=====================" +
            "\n----- SpeedFast -----" +
            "\n=====================");

    ControladorDeEnvios controlador = new ControladorDeEnvios();

    //Llamada directa de datos.
    PedidoComida pedido1 = new PedidoComida("PEDIDO COMIDA", 101, new DireccionEntrega(345, "Los aromos", "Chillán"), 2, true);
    try {
      pedido1.procesarPedido("Isidora López");
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage() + "\nNo es posible asignar repartidor para este pedido.");
    }

    System.out.println("\n----------------------------");

    PedidoEncomienda pedido2 = new PedidoEncomienda("PEDIDO ENCOMIENDA", 102, new DireccionEntrega(456, "Las azucenas", "Concepción"), 12, false);
    try {
      pedido2.procesarPedido("Roberto Labra");
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage() + "\nNo es posible asignar repartidor para este pedido.");
    }

    System.out.println("\n----------------------------");

    PedidoExpress pedido3 = new PedidoExpress("PEDIDO EXPRESS", 103, new DireccionEntrega(567, "Los maitenes", "Temuco"), 6, true);
    try {
      pedido3.procesarPedido("Martina Donaire");

    } catch (IllegalStateException e) {
      System.out.println(e.getMessage() + "\nNo es posible asignar repartidor para este pedido.");
    }

    //REGISTRO DE PEDIDO
    System.out.println("\n--- PEDIDOS REGISTRADOS ---");
    controlador.registrarPedido(pedido1);
    controlador.registrarPedido(pedido2);
    controlador.registrarPedido(pedido3);

    //PROCESAMIENTO DE PEDIDOS
    System.out.println("\n--- PEDIDOS PROCESADOS ---");

    //Llamada de datos de manera polimórfica.
    Pedido[] pedidos = {pedido1, pedido2, pedido3};
    String[] repartidores = {"Isidora López", "Roberto Labra", "Martina Donaire"};

    for (int i = 0; i < pedidos.length; i++) {
      try {
        pedidos[i].procesarPedido(repartidores[i]);
      } catch (IllegalStateException e1) {
        System.out.println(e1.getMessage());
      }
    }

    //CANCELACIÓN DE PEDIDOS
    System.out.println("\n--- PEDIDOS CANCELADOS ---");
    controlador.cancelarPedido(pedido2);

    //DESPACHO DE PEDIDOS
    System.out.println("\n--- PEDIDOS DESPACHADOS ---");
    controlador.despacharPedido(pedido1);
    controlador.despacharPedido(pedido3);

    //HISTORIAL DE PEDIDOS
    System.out.println("\n--- HISTORIAL DE PEDIDOS ---");
    controlador.verHistorial();

    System.out.println("\n--- COMPARACIÓN DE TIEMPOS DE ENVÍO ---");
    System.out.println("Pedido Comida: " + pedido1.calcularTiempoEntrega() + " minutos");
    System.out.println("Pedido Encomienda: " + pedido2.calcularTiempoEntrega() + " minutos");
    System.out.println("Pedido Express: " + pedido3.calcularTiempoEntrega() + " minutos");

    System.out.println("\n======================" +
                    "\n---FIN DEL PROGRAMA---" +
                    "\n======================");
  }
}



