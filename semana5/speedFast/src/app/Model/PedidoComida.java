package app.Model;

import app.Interfaces.Cancelable;
import app.Interfaces.Despachable;


public class PedidoComida extends Pedido implements Despachable, Cancelable{


    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    
    }

    
    @Override
    public double calcularTiempoEntrega() {
        double tiempoInicial = 15;
        double tiempoPorKm = 2;
        double tiempoTotal = tiempoInicial + (tiempoPorKm * getDistanciaKm());
        
        System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos");
        return tiempoTotal;
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Repartidor asignado para comida: " + repartidor);
    }

    
    @Override
    public void mostrarResumen() {
        System.out.println("PedidoComida #" + getIdPedido());
        super.mostrarResumen();
    }

    @Override
    public void despachar(){
        System.out.println("Pedido Comida despachado correctamente");
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando pedido comida #"+ getIdPedido() + "...");
    }
}
