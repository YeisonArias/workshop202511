package volumen;

import java.util.Scanner;

public class VolumenIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar dimensiones al usuario
        System.out.print("Ingrese la dimensión A: ");
        double A = scanner.nextDouble();
        System.out.print("Ingrese la dimensión B: ");
        double B = scanner.nextDouble();
        System.out.print("Ingrese la dimensión C: ");
        double C = scanner.nextDouble();

        //Validar la dimensiones con if anidados
        if (A>0){
            if (B>0){
                if (C>0){
                    double volumen = A * B * C;
                    System.out.print("El volumen de la caja es: " + volumen);
                }else{
                    System.out.print("Error: Las dimensiones deben ser positivas y mayores a 0");
                }
            }else{
                System.out.print("Error: Las dimensiones deben ser positivas y mayores a 0");
            }
        }else{
            System.out.print("Error: Las dimensiones deben ser positivas y mayores a 0");
        }
    }
}
