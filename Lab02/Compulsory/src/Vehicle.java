import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String name;
    private List<Client> clients;


    public Vehicle() {
    }

    public Vehicle(String name, List<Client> clients) {
        this.name = name;
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }
}
