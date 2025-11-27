import java.util.Scanner;

public class TablaDemultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar el numero
        System.out.print("Ingrese un numero: ");
        int numero = scanner.nextInt();

        //Mostrar la tabla de multiplicar del numero hasta el 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

    }
}
