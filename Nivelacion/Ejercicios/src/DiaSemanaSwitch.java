import java.util.Scanner;

public class DiaSemanaSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar el dia de la semana
        System.out.print("Ingrese el dia de la semana (1-7): ");
        int dia = scanner.nextInt();

        //Validar el dia de la semana
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Martes");
                break;
            case 4:
                System.out.println("Miercoles");
                break;
            case 5:
                System.out.println("Jueves");
                break;
            case 6:
                System.out.println("Viernes");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Error: Dia de la semana incorrecto");
                break;
        }

    }
}
