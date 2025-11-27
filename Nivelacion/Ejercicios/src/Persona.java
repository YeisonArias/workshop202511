
public class Persona {
    String nombre;
    String pais;
    int edad;

    // Constructor correcto
    public Persona() {
        nombre = "Diego";
        pais = "Colombia";
        edad = 22;
    }

    // Método saludar
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " de " + pais);
    }
}
