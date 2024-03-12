public abstract class Attraction implements Comparable <Attraction>{
    public String name;

    public Attraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Attraction o) {
        return this.name.compareTo(o.name);
    }
}
