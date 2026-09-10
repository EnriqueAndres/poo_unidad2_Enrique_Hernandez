package app;
import app.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import app.Sincronizacion.ZonaDeCarga;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class Main{
    public static void main(String[] args) throws InterruptedException {
        
        //PedidoHistorial historial = new PedidoHistorial();
        BlockingQueue<Pedido> colaDePedido = new ArrayBlockingQueue<>(6);
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga(colaDePedido);


        //hacer 5 pedidos
        Pedido pedido1 = new Pedido(1, "Santiago Centro", EstadoPedido.PENDIENTE);
        Pedido pedido2 = new Pedido(2,"Providencia", EstadoPedido.PENDIENTE);
        Pedido pedido3 = new Pedido(3, "Las Condes", EstadoPedido.PENDIENTE);
        Pedido pedido4 = new Pedido(4, "Ñuñoa", EstadoPedido.PENDIENTE);
        Pedido pedido5 = new Pedido(5, "La Reina", EstadoPedido.PENDIENTE);


        System.out.println("=======================================");
        System.out.println("               Simulacion");
        System.out.println("=======================================");

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);


        //Ejecucion de hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Enrique", zonaDeCarga));
        executor.execute(new Repartidor("Tedy", zonaDeCarga));
        executor.execute(new Repartidor("Pilar", zonaDeCarga));

        executor.shutdown();
        try {
            executor.awaitTermination(
                    60,
                    TimeUnit.SECONDS
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }


        System.out.println("===========================================================");
        System.out.println("====Todos los pedidos han sido entregados correctamente====");
    }
}