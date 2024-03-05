import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client c1 = new Client();
        c1.setName("Maria");
        c1.setTime(15);
        c1.setType(clientType.REGULAR);

        ////////////

        Vehicle v1 = new Vehicle();
        v1.setName("Vehicle1");
        List<Client> vehicleClients = new ArrayList<>();
        vehicleClients.add(c1);
        v1.setClients(vehicleClients);

        Vehicle v2 = new Vehicle();
        v2.setName("Vehicle2");


        //////////////////////

        Depot d1 = new Depot();
        d1.setName("Depot1");
        List<Vehicle> depotVehicles = new ArrayList<>();
        depotVehicles.add(v1);
        depotVehicles.add(v2);
        d1.setVehicles(depotVehicles);

        System.out.println(c1);
        System.out.println(v1);
        System.out.println(d1);


//        System.out.println("Numele vehiculelor din depozit:");
//        for (Vehicle vehicle : d1.getVehicles()) {
//            System.out.println(vehicle.getName());
//        }
    }
}
