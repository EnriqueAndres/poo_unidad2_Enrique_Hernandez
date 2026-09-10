package app.Sincronizacion;

import java.util.concurrent.BlockingQueue;

import app.Model.Pedido;

public class ZonaDeCarga{
    private final BlockingQueue<Pedido> colaDePedido;

    public ZonaDeCarga(BlockingQueue<Pedido> colaDePedido) {
        this.colaDePedido = colaDePedido;
    }

    //metodo
    public synchronized void agregarPedido(Pedido p) throws InterruptedException {
        colaDePedido.put(p);
        System.out.println("Pedido #" + p.getIdPedido() + " agregado. Destino: " + p.getDireccionEntrega());
    }
    
    public synchronized Pedido retirarPedido(){
        return colaDePedido.poll();
    }
}


/*ejemplo
Pedido #1 agregado. Destino: Santiago Centro
Pedido #2 agregado. Destino: Providencia
Pedido #3 agregado. Destino: Ñuñoa
Pedido #4 agregado. Destino: Recoleta
Pedido #5 agregado. Destino: Las Condes

[Repartidor - Juan] Retirando pedido #1...
[Repartidor - Juan] Estado: EN_REPARTO
[Repartidor - Juan] Entregando pedido #1...
[Repartidor - Juan] Estado: ENTREGADO
l*/