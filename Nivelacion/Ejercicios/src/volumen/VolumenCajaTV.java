package volumen;

import java.util.Scanner;

public class VolumenCajaTV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar las dimensiones
        System.out.print("Ingrese la dimensión A: ");
        double A = scanner.nextDouble();
        System.out.print("Ingrese la dimensión B: ");
        double B = scanner.nextDouble();
        System.out.print("Ingrese la dimensión C: ");
        double C = scanner.nextDouble();

        //Validar dimensiones
        if (A>0 && B>0 && C>0){
            double volumen = A * B * C;
            System.out.println("El volumen de la caja es: " + volumen);
        }else{
            System.out.println("Error: Las dimensiones deben ser positivas y mayores a 0");
        }

    }
}
