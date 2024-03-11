import java.util.Objects;

/**
 * Aceasta enumerare defineste tipurile de clienti posibile.
 */
enum clientType {
    REGULAR,
    PREMIUM
}

/**
 * Aceasta clasa reprezinta un client in cadrul sistemului logistic.
 */
public class Client {
    private String name;
    private int start_time;
    private int end_time;
    private clientType type;

    /**
     * Constructor pentru initializarea unui client fara specificarea numelui, timpului de inceput, timpului de sfarsit sau a tipului.
     */
    public Client() {
    }

    /**
     * Constructor pentru initializarea unui client cu un nume, un timp de inceput, un timp de sfarsit si un tip specificate.
     *
     * @param name       Numele clientului.
     * @param start_time Timpul de inceput al serviciului.
     * @param end_time   Timpul de sfarsit al serviciului.
     * @param type       Tipul clientului.
     */
    public Client(String name, int start_time, int end_time, clientType type) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
    }

    /**
     * Returneaza numele clientului.
     *
     * @return Numele clientului.
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele clientului.
     *
     * @param name Noul nume al clientului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returneaza timpul de inceput al serviciului.
     *
     * @return Timpul de inceput al serviciului.
     */
    public int getStart_time() {
        return start_time;
    }

    /**
     * Seteaza timpul de inceput al serviciului.
     *
     * @param start_time Noul timp de inceput al serviciului.
     */
    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    /**
     * Returneaza timpul de sfarsit al serviciului.
     *
     * @return Timpul de sfarsit al serviciului.
     */
    public int getEnd_time() {
        return end_time;
    }

    /**
     * Seteaza timpul de sfarsit al serviciului.
     *
     * @param end_time Noul timp de sfarsit al serviciului.
     */
    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    /**
     * Returneaza tipul clientului.
     *
     * @return Tipul clientului.
     */
    public clientType getType() {
        return type;
    }

    /**
     * Seteaza tipul clientului.
     *
     * @param type Noul tip al clientului.
     */
    public void setType(clientType type) {
        this.type = type;
    }

    /**
     * Verifica egalitatea intre doua obiecte de tip Client.
     *
     * @param o Obiectul de comparat cu instanta curenta.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return start_time == client.start_time && end_time == client.end_time && Objects.equals(name, client.name) && type == client.type;
    }

    /**
     * Returneaza valoarea de hash a obiectului.
     *
     * @return Valoarea de hash a obiectului.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, start_time, end_time, type);
    }

    /**
     * Returneaza o reprezentare sub forma de sir de caractere a obiectului Client.
     *
     * @return O reprezentare sub forma de sir de caractere.
     */
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", type=" + type +
                '}';
    }
}
