/**
 * Clase base del sistema de pedidos.
 * Representa un pedido genérico.
 */

public abstract class Pedido {

    private String tipoPedido;
    private int idPedido;
    private DireccionEntrega direccionEntrega;
    private int distanciaKm;
    private String estadoPedido;

    /**
     * Constructor de la clase Pedido:
     * @param tipoPedido       Tipo de pedido.
     * @param idPedido         Número de identificación del pedido.
     * @param direccionEntrega Dirección de entrega del pedido.
     * @param distanciaKm      Distancia en km del punto de entrega del pedido.
     */
    public Pedido(String tipoPedido, int idPedido, DireccionEntrega direccionEntrega, int distanciaKm) {

        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estadoPedido = "REGISTRADO";
    }

    //Métodos getter.

    public String getTipoPedido() {
        return tipoPedido;
    }

    public int getId() {
        return idPedido;
    }

    public DireccionEntrega getDireccionEntrega() {
        return direccionEntrega;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    //Métodos setter.

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public void setId(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(DireccionEntrega direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    /**
     * Metodo concreto mostrarResumen.
     * Muestra los datos en consola.
     */
    public void mostrarResumen() {
        System.out.println("\n[" + tipoPedido + "]" +
                "\nN° " + idPedido +
                "\nDirección de entrega: " + direccionEntrega +
                "\nDistancia: " + distanciaKm + " Km.");
    }

    public void asignarRepartidor() {
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Buscando repartidor...");
        System.out.println("Repartidor asignado: " + nombreRepartidor);
    }

    /**
     * Metodo abstracto que calcula el tiempo de entrega del pedido.
     * @return tiempo de espera del pedido.
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Template Method
     * @param nombreRepartidor Nombre del repartidor.
     */
    public void procesarPedido(String nombreRepartidor) {
        mostrarResumen();
        asignarRepartidor(nombreRepartidor);
        int tiempo = calcularTiempoEntrega();
        System.out.println("\nTiempo estimado de entrega: " + tiempo + " minutos.");
    }
}
