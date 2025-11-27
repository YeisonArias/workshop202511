import java.util.Scanner;

public class ClasificacionPorEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar Edad
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();

        //Clasificación según la edad
        if(edad>=0 && edad<=10){
            System.out.println("Niño");
        }else if(edad>=11 && edad<=14){
            System.out.println("Pre-Adolescente");
        }else if(edad>=15 && edad<=18){
            System.out.println("Adolescente");
        }else if(edad>=19 && edad<=25){
            System.out.println("Joven");
        }else if(edad>=26 && edad<=65){
            System.out.println("Adulto");
        }else if(edad>65 && edad<=120){
            System.out.println("Adulto Maduro");
        }else{
            System.out.println("Error: La edad debe ser entre 0 y 120");
        }


    }
}
