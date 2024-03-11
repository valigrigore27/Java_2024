import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Aceasta clasa reprezinta un depozit in cadrul sistemului logistic.
 */
public class Depot {

    private String name;
    private List<Vehicle> vehicles;

    /**
     * Constructor pentru initializarea unui depozit fara specificarea numelui sau a listei de vehicule.
     */
    public Depot() {
    }

    /**
     * Constructor pentru initializarea unui depozit cu un nume si o lista de vehicule specificate.
     *
     * @param name     Numele depozitului.
     * @param vehicles Lista de vehicule din depozit.
     */
    public Depot(String name, List<Vehicle> vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    /**
     * Returneaza numele depozitului.
     *
     * @return Numele depozitului.
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele depozitului.
     *
     * @param name Noul nume al depozitului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returneaza lista de vehicule din depozit.
     *
     * @return Lista de vehicule din depozit.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Seteaza lista de vehicule din depozit.
     *
     * @param vehicles Noua lista de vehicule din depozit.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Adauga un vehicul in lista de vehicule din depozit.
     *
     * @param vehicle Vehiculul de adaugat.
     */
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    /**
     * Verifica egalitatea intre doua obiecte de tip Depot.
     *
     * @param o Obiectul de comparat cu instanta curenta.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name) && Objects.equals(vehicles, depot.vehicles);
    }

    /**
     * Returneaza valoarea de hash a obiectului.
     *
     * @return Valoarea de hash a obiectului.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, vehicles);
    }

    /**
     * Returneaza o reprezentare sub forma de sir de caractere a obiectului Depot.
     *
     * @return O reprezentare sub forma de sir de caractere.
     */
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
