package app.Model;

import app.Interfaces.Rastreable;
import java.util.List;
import java.util.ArrayList;

public class PedidoHistorial implements Rastreable {
  
    private List<String> registros = new ArrayList<>();

    public void registro(int idPedido, String tipoPedido, String repartidor){
        String idCambio = String.valueOf(idPedido);
        String detalleHistorial = tipoPedido + " #" + idCambio + " - " + "entregado por " + repartidor;  
        registros.add(detalleHistorial);
    }

    @Override
    public List<String> verHistorial(){
        return new ArrayList<>(this.registros);
    }
}
