import java.util.Map;

public class Statue extends Attraction{

    public Statue(String name){
        super(name);

    }
    public Statue(String name, Map<String, Interval> map) {
        super(name, map);
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }
}

