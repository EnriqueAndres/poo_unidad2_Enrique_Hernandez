package app;
import app.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main{
    public static void main(String[] args) {
        
        PedidoHistorial historial = new PedidoHistorial();

        

        PedidoComida pedido1 = new PedidoComida(1, "Calle Santos 12", 4);

        pedido1.mostrarResumen();
        pedido1.calcularTiempoEntrega();
        pedido1.asignarRepartidor("Enrique");
        pedido1.asignarRepartidor();
        pedido1.despachar();
        historial.registro(pedido1.getIdPedido(), PedidoComida.class.getSimpleName(), pedido1.getRepartidor());
        

        pedido1.cancelar();

        System.out.println("---------------------------");

        PedidoComida pedido2 = new PedidoComida(2, "Calle flor 34", 4);

        pedido2.mostrarResumen();
        pedido2.calcularTiempoEntrega();
        pedido2.asignarRepartidor("Enrique");
        pedido2.asignarRepartidor();
        pedido2.despachar();
        historial.registro(pedido2.getIdPedido(), PedidoComida.class.getSimpleName(), pedido2.getRepartidor());

        System.out.println("---------------------------");

        PedidoEncomienda pedido3 = new PedidoEncomienda(3, "Calle sur 450", 10);
        pedido3.mostrarResumen();
        pedido3.calcularTiempoEntrega();
        pedido3.asignarRepartidor("Tedy");
        pedido3.asignarRepartidor();
        pedido3.despachar();
        historial.registro(pedido3.getIdPedido(), PedidoEncomienda.class.getSimpleName(), pedido3.getRepartidor());

        System.out.println("-------------------------");
        
        PedidoEncomienda pedido4 = new PedidoEncomienda(4, "Calle norte 845", 9);

        pedido4.mostrarResumen();
        pedido4.calcularTiempoEntrega();
        pedido4.asignarRepartidor("Norma");
        pedido4.asignarRepartidor();
        pedido4.despachar();
        historial.registro(pedido4.getIdPedido(), PedidoEncomienda.class.getSimpleName(), pedido4.getRepartidor());

        System.out.println("--------------------------");

        PedidoExpress pedido5 = new PedidoExpress(5, "Calle oeste 1234", 12);

        pedido5.mostrarResumen();
        pedido5.calcularTiempoEntrega();
        pedido5.asignarRepartidor("Pilar");
        pedido5.asignarRepartidor();
        pedido5.despachar();
        historial.registro(pedido5.getIdPedido(), PedidoExpress.class.getSimpleName(), pedido5.getRepartidor());

        pedido5.cancelar();

        System.out.println("=======================================");
        System.out.println("Simulacion");
        //Ejecucion de hilos
        List<Pedido> listaEnrique = new ArrayList<>();
        listaEnrique.add(pedido1);
        listaEnrique.add(pedido2);

        List<Pedido> listaTedy = new ArrayList<>();
        listaTedy.add(pedido3);

        List<Pedido> listaPilar = new ArrayList<>();
        listaPilar.add(pedido5);

        Repartidor r1 = new Repartidor("Enrique", listaEnrique);
        Repartidor r2 = new Repartidor("Tedy", listaTedy);
        Repartidor r3 = new Repartidor("Pilar", listaPilar);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();


        System.out.println("-------------------------------");
        System.out.println("Historial");
        for (String i : historial.verHistorial()){
            
            System.out.println("- " + i);
        }

        System.out.println("=================================================");
        System.out.println("=================Simulacion Hilos================");
    }
}