import java.util.List;

/**
 * Aceasta clasa reprezinta un dron in cadrul sistemului logistic.
 */
public class Drone extends Vehicle {
    private long duration;

    /**
     * Constructor pentru initializarea unui dron fara specificarea numelui, listei de clienti, depozitului, timpului curent sau a duratei de zbor.
     */
    public Drone() {
    }

    /**
     * Constructor pentru initializarea unui dron cu un nume, o lista de clienti, un depozit, un timp curent si o durata de zbor specificate.
     *
     * @param name        Numele dronului.
     * @param clients     Lista de clienti asociati dronului.
     * @param depot       Depozitul la care este asociat dronul.
     * @param currentTime Timpul curent al dronului.
     * @param duration    Durata de zbor a dronului.
     */
    public Drone(String name, List<Client> clients, Depot depot, int currentTime, long duration) {
        super(name, clients, depot, currentTime);
        this.duration = duration;
    }

    /**
     * Returneaza durata de zbor a dronului.
     *
     * @return Durata de zbor a dronului.
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Seteaza durata de zbor a dronului.
     *
     * @param duration Noua durata de zbor a dronului.
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }
}
