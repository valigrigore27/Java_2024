import java.util.ArrayList;
import java.util.List;

public class Depot {

    private String name;
    private List<Vehicle> vehicles;

    public Depot() {
    }

    public Depot(String name, List<Vehicle> vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
