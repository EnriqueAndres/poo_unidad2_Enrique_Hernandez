package app.Model;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    //getters
    public String getNombre(){
        return this.nombre;
    }

    public List<Pedido> getPedidosAsignados() {
        return this.pedidosAsignados;
    }


    @Override
    public void run(){
        Random random = new Random();

        for(Pedido pedido : pedidosAsignados){
            try{
            System.out.println("Repartidor: " + this.nombre + ", Entregando " + pedido.getClass().getSimpleName() + " #"+ pedido.getIdPedido()+"...");
                
            int simulacionEntrega = random.nextInt(3000) + 1000;
            Thread.sleep(simulacionEntrega);


            System.out.println("Repartidor: "+ this.nombre + " Pedido #" + pedido.getIdPedido()+ " entregado.");
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }
        

    }

}


