import java.util.Scanner;

public class Vectores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Vectores de notas y porcentajes
        double[] notas = new double[5];
        double[] porcentajes = {20,10,30,20,20};

        //Solicitar las notas al usuario
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        //Calcular la nota final
        double notaFinal = 0;
        for (int i = 0; i < notas.length; i++) {
            notaFinal += notas[i] * (porcentajes[i] / 100);
        }

        //Mostrar la nota final
        System.out.println("La nota final es: " + notaFinal);
    }
}
