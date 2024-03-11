import java.util.List;

/**
 * Aceasta clasa reprezinta un camion in cadrul sistemului logistic.
 */
public class Truck extends Vehicle {
    private int capacity;

    /**
     * Constructor pentru initializarea unui camion fara specificarea numelui, listei de clienti, depozitului, timpului curent sau a capacitatii.
     */
    public Truck() {
    }

    /**
     * Constructor pentru initializarea unui camion cu un nume, o lista de clienti, un depozit, un timp curent si o capacitate specificate.
     *
     * @param name        Numele camionului.
     * @param clients     Lista de clienti asociati camionului.
     * @param depot       Depozitul la care este asociat camionul.
     * @param currentTime Timpul curent al camionului.
     * @param capacity    Capacitatea camionului.
     */
    public Truck(String name, List<Client> clients, Depot depot, int currentTime, int capacity) {
        super(name, clients, depot, currentTime);
        this.capacity = capacity;
    }

    /**
     * Returneaza capacitatea camionului.
     *
     * @return Capacitatea camionului.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Seteaza capacitatea camionului.
     *
     * @param capacity Noua capacitate a camionului.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
