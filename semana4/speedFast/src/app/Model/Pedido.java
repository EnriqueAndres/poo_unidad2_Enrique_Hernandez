package app.Model;

public abstract class Pedido {

    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    protected String repartidor;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidor = "Sin repartidor";
    }
    //getters
    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidor(){
        return repartidor;
    }

    //metodo
    public void mostrarResumen(){
        System.out.println("Dirección de Entrega: " + direccionEntrega + ", Distancia: " + distanciaKm + " km");
    }

    public void asignarRepartidor(){}

    public void asignarRepartidor(String repartidor){
        if (repartidor != null && !repartidor.isEmpty()){
            this.repartidor = repartidor;
    
        }else{
            this.repartidor = "Anonimo";
        }
        
    }

    //metodo abstracto
    public abstract double calcularTiempoEntrega();
    
}
