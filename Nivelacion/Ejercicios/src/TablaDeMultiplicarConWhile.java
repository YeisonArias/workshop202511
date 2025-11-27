import java.util.Scanner;

public class TablaDeMultiplicarConWhile {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Ingrese un número: ");
      int numero = scanner.nextInt();
      int i = 1;

      while (i <= 100) {
        System.out.println(numero + " x " + i + " = " + (numero * i));
        i++;
      }
    }
}
