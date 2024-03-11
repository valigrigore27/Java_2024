import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Aceasta clasa reprezinta un vehicul abstract in cadrul sistemului logistic.
 */
public abstract class Vehicle {
    private String name;
    private List<Client> clients;

    private Depot depot;
    private int currentTime;

    /**
     * Constructor pentru initializarea unui vehicul fara specificarea numelui, listei de clienti, depozitului sau timpului curent.
     */
    public Vehicle() {
    }

    /**
     * Constructor pentru initializarea unui vehicul cu un nume, o lista de clienti, un depozit si un timp curent specificate.
     *
     * @param name        Numele vehiculului.
     * @param clients     Lista de clienti asociati vehiculului.
     * @param depot       Depozitul la care este asociat vehiculul.
     * @param currentTime Timpul curent al vehiculului.
     */
    public Vehicle(String name, List<Client> clients, Depot depot, int currentTime) {
        this.name = name;
        this.clients = clients;
        this.depot = depot;
        this.currentTime = currentTime;
    }

    /**
     * Returneaza numele vehiculului.
     *
     * @return Numele vehiculului.
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele vehiculului.
     *
     * @param name Noul nume al vehiculului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returneaza lista de clienti asociati vehiculului.
     *
     * @return Lista de clienti asociati vehiculului.
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Seteaza lista de clienti asociati vehiculului.
     *
     * @param clients Noua lista de clienti asociati vehiculului.
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Returneaza depozitul la care este asociat vehiculul.
     *
     * @return Depozitul la care este asociat vehiculul.
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Seteaza depozitul la care este asociat vehiculul.
     *
     * @param depot Noul depozit la care este asociat vehiculul.
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    /**
     * Returneaza timpul curent al vehiculului.
     *
     * @return Timpul curent al vehiculului.
     */
    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * Seteaza timpul curent al vehiculului.
     *
     * @param currentTime Noul timp curent al vehiculului.
     */
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Verifica egalitatea intre doua obiecte de tip Vehicle.
     *
     * @param o Obiectul de comparat cu instanta curenta.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return currentTime == vehicle.currentTime && Objects.equals(name, vehicle.name) && Objects.equals(clients, vehicle.clients) && Objects.equals(depot, vehicle.depot);
    }

    /**
     * Returneaza valoarea de hash a obiectului.
     *
     * @return Valoarea de hash a obiectului.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, clients, depot, currentTime);
    }

    /**
     * Returneaza o reprezentare sub forma de sir de caractere a obiectului Vehicle.
     *
     * @return O reprezentare sub forma de sir de caractere.
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                ", depot=" + depot +
                ", currentTime=" + currentTime +
                '}';
    }
}
