package sobrecarga;

public class Persona {
    String nombre;
    int edad;
    String genero;

    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void informacion(){
        System.out.println("Yo me llamo "+nombre);
    }

    public void informacion(String genero){
        System.out.println("Mi genero es "+genero);
    }
}
