package app.Model;

import app.Interfaces.Cancelable;
import app.Interfaces.Despachable;

public class PedidoExpress extends Pedido implements Despachable, Cancelable{


    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public double calcularTiempoEntrega() {
        double tiempoInicial = 10;
        double tiempoTotal = 0;

        if (getDistanciaKm() > 5) {
            tiempoTotal = tiempoInicial + 5;
        } else {
            tiempoTotal = tiempoInicial;
        }
        System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos");
        return tiempoTotal;
    }


    @Override
    public void mostrarResumen() {
        System.out.println("PedidoExpress #" + getIdPedido());
        super.mostrarResumen();
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Buscando repartidor para entrega pedido express: " + repartidor);
    }


    @Override
    public void despachar(){
        System.out.println("Pedido express despachado correctamente");
    }

    @Override
    public void cancelar(){
        System.out.println("Cancelando pedido express #" + getIdPedido() +"...");
    }
}
