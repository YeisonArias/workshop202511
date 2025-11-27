package metodos;

public class Carro {
    //Atributos
    private String marca;
    private int velocidad;

    //Constructor
    public Carro(String marca, int velocidad) {
        this.marca = marca;
        this.velocidad = velocidad;
    }

    //Metodo de tipo: void no retorna nada
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("El carro de marca " + marca + " esta acelerando a " + velocidad + " km/h");
    }

    //Metodo de tipo: int retorna un valor
    public int velocidad() {
        return velocidad;
    }

    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", 0);
        carro1.acelerar(50);
        int velocidadActual = carro1.velocidad();
        System.out.println("La velocidad del carro es: " + carro1.velocidad());
    }

}
