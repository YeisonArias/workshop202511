package parametrosyargumentos;

public class Operaciones {
    //Atributos
    int suma;
    int resta;
    int multiplicacion;
    int division;

    //Metodo para sumar 2 valores
    public void sumar(int a, int b){
        suma = a + b;
    }

    //Metodos para restar 2 valores
    public void restar(int a, int b){
        resta = a - b;
    }

    //Metodo para multiplicar 2 valores
    public void multiplicar(int a, int b){
        multiplicacion = a * b;
    }

    //Metodo para dividir 2 valores
    public void dividir(int a, int b){
        division = a / b;
    }

    //Metodo para mostrar resultados
    public void mostrarResultados(){
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);
        System.out.println("Division: " + division);
    }
}
