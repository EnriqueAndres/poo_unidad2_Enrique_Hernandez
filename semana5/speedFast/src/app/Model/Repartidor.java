package app.Model;
import java.util.List;
import java.util.Random;
import app.Sincronizacion.ZonaDeCarga;

public class Repartidor implements Runnable {
    private String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    //getters
    public String getNombre(){
        return this.nombre;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return this.zonaDeCarga;
    }


    @Override
    public void run(){
        Random random = new Random();

        while(true){
            Pedido pedido = zonaDeCarga.retirarPedido();
            // para terminar el bucle
            if(pedido == null){break;}

            try{
            System.out.println("Repartidor: " + this.nombre + ", retirando pedido " + " #"+ pedido.getIdPedido()+"...");
                
            int simulacionEntrega = random.nextInt(3000) + 1000;
            Thread.sleep(simulacionEntrega);
            
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("Repartidor: "+ this.nombre + " | Estado: " + pedido.getEstado());

            Thread.sleep(simulacionEntrega);

            System.out.println("Repartidor: "+ this.nombre + " | Pedido #" + pedido.getIdPedido()+ " entregado.");
            Thread.sleep(simulacionEntrega);
            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("Repartidor: "+ this.nombre + " | Estado: " + pedido.getEstado());

            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }

        }
        

    }

}


