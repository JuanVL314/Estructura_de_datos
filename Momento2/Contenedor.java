public class Contenedor {

    //atributos
    private String id ;
    private double peso ;
    private int prioridad ;

    public Contenedor ( String id , double peso , int prioridad ) {
    this . id = id ;
    this . peso = peso ;
    this . prioridad = prioridad ;
    }

    public String getId(){
        return id;
    }

    public double getPeso(){
        return peso;
    
    }
    public int getPrioridad(){
        return prioridad;
    }
    @Override
    public String toString() {
        return "[" + id + " | Peso: " + peso + " | Prioridad: " + prioridad + "]";
    }

}
