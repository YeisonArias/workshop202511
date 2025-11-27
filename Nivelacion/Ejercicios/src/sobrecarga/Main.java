package sobrecarga;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 25, "Masculino");
        persona1.informacion();
        persona1.informacion("Masculino");
    }
}
