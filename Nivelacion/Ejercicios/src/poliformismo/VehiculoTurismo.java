package poliformismo;

public class VehiculoTurismo extends Vehiculo {
    private int puertas;

    public VehiculoTurismo(String matricula, String marca, String modelo, int puertas) {
        super(matricula, marca, modelo);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public String mostrarInformacion(){
        return "Matricula:"+this.matricula+"\n"+"Marca:"+this.marca+"\n"+"Modelo:"+this.modelo+"\n"+"Puertas:"+this.puertas;
    }
}
