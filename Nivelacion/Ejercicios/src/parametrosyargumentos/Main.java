package parametrosyargumentos;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el número 1: "));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el número 2: "));

        Operaciones operaciones = new Operaciones();
        operaciones.sumar(numero1, numero2);
        operaciones.restar(numero1, numero2);
        operaciones.multiplicar(numero1, numero2);
        operaciones.dividir(numero1, numero2);
        operaciones.mostrarResultados();
    }
}
