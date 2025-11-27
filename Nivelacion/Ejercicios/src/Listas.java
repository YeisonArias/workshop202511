import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        //Crear una lista de tipo Sting
        List<String> lista = new ArrayList<String>();

        //Agregar elementos a la lista
        lista.add("Manzana");
        lista.add("Banana");
        lista.add("Mango");
        lista.add("Uva");
        lista.add("Piña");

        //Imprimir la lista
        System.out.println("Lista de frutas: " + lista);

        //Acceder a un elementos de la lista
        for (int i = 0; i <lista.size() ; i++) {
            System.out.println("El elemento de la lista en la posición "+ i + " es: " + lista.get(i));
        }

        //Eliminar un elemento de la lista
        lista.remove("Mango");
        System.out.println("Lista de frutas: " + lista);

    }
}
