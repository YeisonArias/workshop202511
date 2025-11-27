package poliformismo;

public class VehiculloDeportivo extends Vehiculo {
    private int cilindrada;

    public VehiculloDeportivo(String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String mostrarInformacion(){
        return "Matricula:"+this.matricula+"\n"+"Marca:"+this.marca+"\n"+"Modelo:"+this.modelo+"\n"+"Cilindrada:"+this.cilindrada;
    }
}
