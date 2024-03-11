import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Aceasta clasa reprezinta o problema de alocare a resurselor in cadrul unui sistem logistic.
 */
public class Problem {
    private List<Depot> depots;

    /**
     * Constructor pentru initializarea unei instante de Problem.
     */
    public Problem() {
        this.depots = new ArrayList<>();
    }

    /**
     * Returneaza lista de depozite.
     *
     * @return Lista de depozite.
     */
    public List<Depot> getDepots() {
        return depots;
    }

    /**
     * Seteaza lista de depozite.
     *
     * @param depots Lista de depozite.
     */
    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    /**
     * Adauga un depozit la lista de depozite.
     *
     * @param depot Depozitul de adaugat.
     */
    public void addDepot(Depot depot) {
        this.depots.add(depot);
    }

    /**
     * Returneaza toate vehiculele din toate depozitele sub forma de array.
     *
     * @return Array-ul de vehicule.
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }
        return allVehicles.toArray(new Vehicle[0]);
    }

    /**
     * Alocati clientii la vehiculele disponibile.
     *
     * @param clients Lista de clienti care trebuie alocati.
     */
    public void allocateClients(List<Client> clients) {
        for (Depot depot : depots) {
            List<Vehicle> vehicles = depot.getVehicles();
            for (Vehicle vehicle : vehicles) {
                clients.sort(Comparator.comparingInt(Client::getStart_time));
                List<Client> allocatedClients = new ArrayList<>();
                for (Client client : clients) {
                    if (client.getStart_time() <= vehicle.getCurrentTime() &&
                            client.getEnd_time() >= vehicle.getCurrentTime()) {
                        allocatedClients.add(client);
                        //vehicle.setCurrentTime(client.getEnd_time());
                    }
                }
                clients.removeAll(allocatedClients);
                vehicle.setClients(allocatedClients);
            }
        }
    }

    /**
     * Returneaza o reprezentare sub forma de sir de caractere a obiectului Problem.
     *
     * @return O reprezentare sub forma de sir de caractere.
     */
    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                '}';
    }
}
