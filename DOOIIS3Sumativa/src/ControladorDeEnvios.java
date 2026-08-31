import java.util.ArrayList;

/**
 * Clase que controla el sistema de envíos, implementando la interfaz Rastreable que hace posible la visualización del historial de pedidos.
 */

public class ControladorDeEnvios implements Rastreable {

    private ArrayList<Pedido> pedidos;

    public ControladorDeEnvios() {
        pedidos = new ArrayList<>();
    }

    //Metodo que registra el pedido
    public void registrarPedido(Registrable pedido) {
        pedidos.add((Pedido) pedido);
        pedido.registrar();
        System.out.println("Pedido registrado");
    }

    //Metodo que cancela el pedido
    public void cancelarPedido(Cancelable pedido) {
        pedido.cancelar();
        System.out.println("Pedido cancelado.");
    }

    //Metodo que despacha el pedido
    public void despacharPedido(Despachable pedido) {
        pedido.despachar();
        System.out.println("Pedido enviado.");
    }

    //Metodo para ver historial
    @Override
    public void verHistorial() {
        if (pedidos.isEmpty()) {
            System.out.println("Aún no hay pedidos registrados.");
            return;
        }

        int pedidosDespachados = 0;

        for (Pedido pedido : pedidos) {
            System.out.println("N° " + pedido.getId() + "| " + pedido.getTipoPedido() + "|" + pedido.getDireccionEntrega() + "| " + pedido.getDistanciaKm() + "| " + pedido.getEstadoPedido() + "| " + pedido.calcularTiempoEntrega() + "min.");

            if (pedido.getEstadoPedido().equals("DESPACHADO")) {
                pedidosDespachados++;
            }
        }

        if (pedidosDespachados == 0) {
            System.out.println("\nAún no hay pedidos despachados.");
        } else {
            System.out.println("\nTotal de pedidos despachados: " + pedidosDespachados);
        }
    }
}