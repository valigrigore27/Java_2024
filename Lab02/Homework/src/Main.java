import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //CLIENTS
        Client client1 = new Client("Client1", 10, 13, clientType.REGULAR);
        Client client2 = new Client("Client2", 11, 15, clientType.PREMIUM);
        Client client3 = new Client("Client3", 12, 18, clientType.REGULAR);
        Client client4=  new Client("Client4", 16, 20, clientType.REGULAR);
        Client client5=  new Client("Client5", 10, 12, clientType.REGULAR);


        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);



        //VECHICLES

        Truck truck = new Truck();
        truck.setCapacity(10000);
        truck.setName("Truck");
        truck.setCurrentTime(11);

        Drone drone = new Drone();
        drone.setDuration(100);
        drone.setName("Drone1");
        drone.setCurrentTime(14);

        Truck truck1 = new Truck();
        truck1.setCapacity(15000);
        truck1.setName("Truck1");
        truck1.setCurrentTime(17);

        List <Vehicle> vehiclesDepot1 = new ArrayList<>();
        vehiclesDepot1.add(truck);
        vehiclesDepot1.add(drone);
        List <Vehicle> vehiclesDepot2 = new ArrayList<>();
        vehiclesDepot2.add(truck1);


        //DEPOTS

        Depot depot1 = new Depot("Depot1", vehiclesDepot1);
        Depot depot2 = new Depot("Depot2", vehiclesDepot2);


        //PROBLEM

        Problem problem = new Problem();
        problem.addDepot(depot1);
        problem.addDepot(depot2);

        System.out.println("Before allocation: ");
        for (Depot depot : problem.getDepots()) {
            System.out.println(depot);
        }

        //Allocation
        problem.allocateClients(clients);
        System.out.println();

        System.out.println("After allocation: ");
        for (Depot depot : problem.getDepots()) {
            System.out.println(depot);
        }

        System.out.println();
        //System.out.println(clients);
    }
}