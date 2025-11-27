public class EqualsIg {
    public static void main(String[] args) {
        String texto1 = new String("Hola");
        String texto2 = new String("Hola");

        System.out.println(texto1 == texto2); //false
        System.out.println(texto1.equals(texto2)); //true
    }
}
