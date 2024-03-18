import java.time.LocalTime;
import java.util.Map;

public abstract class Attraction implements Comparable <Attraction>{
    public String name;
    public Map<String, Interval> map;

    public Attraction(String name){
        this.name = name;
    }
    public Attraction(String name, Map<String, Interval> map) {
        this.name = name;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Interval> getMap() {
        return map;
    }

    public void setMap(Map<String, Interval> map) {
        this.map = map;
    }

//    @Override
//    public int compareTo(Attraction o) {
//
//    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", map=" + map +
                '}';
    }
}
