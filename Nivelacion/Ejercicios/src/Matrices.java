import java.util.Random;

public class Matrices {
    public static void main(String[] args) {
        int filas=5;
        int columnas=4;
        int[][] matriz = new int[filas][columnas];

        Random random = new Random();
        //Llenar la matriz con valores aleatorios
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }

        //Imprimir la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}
