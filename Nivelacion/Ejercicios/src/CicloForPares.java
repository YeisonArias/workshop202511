public class CicloForPares {
    public static void main(String[] args) {
        //Usamos el ciclo for para imprimir los numeros pares del 1 al 100
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
