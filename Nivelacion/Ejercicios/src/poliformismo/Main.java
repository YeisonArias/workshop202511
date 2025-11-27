package poliformismo;

public class Main {
    public static void main(String[] args) {
        Vehiculo misVehiculos[] = new Vehiculo[4];
        misVehiculos[0] = new Vehiculo("1234 ABC", "Seat", "Ibiza");
        misVehiculos[1] = new VehiculoTurismo("5678 DEF", "Renault", "Clio", 5);
        misVehiculos[2] = new VehiculloDeportivo("9012 GHI", "Opel", "Astra", 5);
        misVehiculos[3] = new VehiculoFurgoneta("3456 JKL", "Volkswagen", "Golf", 5);

        for (int i = 0; i < misVehiculos.length; i++) {
            System.out.println(misVehiculos[i].mostrarInformacion());
        }
    }
}
