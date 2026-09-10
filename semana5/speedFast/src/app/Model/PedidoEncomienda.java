
package app.Model;

import app.Interfaces.Cancelable;
import app.Interfaces.Despachable;


public class PedidoEncomienda extends Pedido implements Despachable, Cancelable{


    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

   
    @Override
    public double calcularTiempoEntrega() {
        double tiempoInicial = 20;
        double tiempoPorKm = 1.5;
        int tiempoTotal = (int) Math.ceil(tiempoInicial + (tiempoPorKm * getDistanciaKm()));
        
        System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos");
        return tiempoTotal;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("PedidoEncomienda #" + getIdPedido());
        super.mostrarResumen();
    }


    @Override
    public void asignarRepartidor(){
        System.out.println("Buscando repartidor para entrega de encomienda: " + repartidor);
    }

    
    @Override
    public void despachar(){
        System.out.println("Pedido despachado correctamente");
    }

    @Override
    public void cancelar(){
        System.out.println("Cancelando pedido encomienda #"+ getIdPedido() + "...");
    }
}