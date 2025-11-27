
public class Carro {
    private String marca;
    private int velocidad;

    // Constructor
    public Carro(String marca) {
        this.marca = marca;
        this.velocidad = 0;
    }

    // Método void: realiza una acción sin retornar valor
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("El carro " + marca + " aceleró a " + velocidad + " km/h");
    }

    // Método de tipo: retorna un valor (int)
    public int obtenerVelocidad() {
        return velocidad;
    }

    public static void main(String[] args) {
        Carro miCarro = new Carro("Toyota");
        miCarro.acelerar(50); // Método void
        int velocidadActual = miCarro.obtenerVelocidad(); // Método de tipo
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
    }
}
