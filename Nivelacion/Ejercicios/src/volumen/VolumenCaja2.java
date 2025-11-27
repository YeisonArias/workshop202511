package volumen;

import java.util.Scanner;

public class VolumenCaja2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar las dimensiones al usuario
        System.out.print("Ingrese la dimension A: ");
        double A = scanner.nextDouble();
        System.out.print("Ingrese la dimension B: ");
        double B = scanner.nextDouble();
        System.out.print("Ingrese la dimension C: ");
        double C = scanner.nextDouble();

        //Calcular el volumen
        double volumen = A * B * C;

        //Mostrar el resultado
        System.out.println("El volumen de la caja es: " + volumen);

    }
}
