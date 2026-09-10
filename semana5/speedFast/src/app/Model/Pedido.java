package app.Model;

public class Pedido {

    private final int id;
    private String direccionEntrega;
    private  EstadoPedido estado;
    

    public Pedido(int id, String direccionEntrega, EstadoPedido estado) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
    }
    //getters
    public int getIdPedido() {
        return this.id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    //setters
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    //metodo
    public void setEstado(String nuevoEstado){
        try {
            this.estado = EstadoPedido.valueOf(nuevoEstado.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no reconocible para el pedido #" + this.id);
        }     
    }
    
    @Override 
    public String toString() {
        return "Pedido #" + id + ", Dirección: " + direccionEntrega + ", Estado: " + estado;
    }


}
