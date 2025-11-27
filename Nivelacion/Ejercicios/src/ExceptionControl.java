public class ExceptionControl {
    public static int numerador=10;
    public static Integer denumerador=0;
    public static float resultado;
    public static void main(String[] args) {
        System.out.println("ANTES DE LA DIVISIÓN");
        try {
            resultado = numerador / denumerador;

     } catch (Exception e) {
            System.out.println(e.getMessage());
     }finally {
            System.out.println("resultado: "+resultado);
            System.out.println("DESPUES DE LA DIVISIÓN");
        }
    }
}
