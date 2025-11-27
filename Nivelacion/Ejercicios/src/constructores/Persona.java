package constructores;

import javax.swing.*;

public class Persona {
    //Atributos
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "¡Hola! Este es un mi nombre: "+nombre);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}
