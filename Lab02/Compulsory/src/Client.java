enum clientType{
    REGULAR,
    PREMIUM
}
public class Client {
    private String name;
    private int time;
    private clientType type;

    public Client() {
    }

    public Client(String name, int time, clientType type) {
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public clientType getType() {
        return type;
    }

    public void setType(clientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

