package poliformismo;

public class VehiculoFurgoneta extends Vehiculo {
    private int carga;

    public VehiculoFurgoneta(String matricula, String marca, String modelo, int carga) {
        super(matricula, marca, modelo);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public String mostrarInformacion(){
        return "Matricula:"+this.matricula+"\n"+"Marca:"+this.marca+"\n"+"Modelo:"+this.modelo+"\n"+"Carga:"+this.carga;
    }
}
