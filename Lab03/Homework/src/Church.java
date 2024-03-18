import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Church extends Attraction implements Visitable{


    public Church(String name){
        super(name);
    }
    public Church(String name, Map<String, Interval> map) {
        super(name, map);
    }

    @Override
    public int compareTo(Attraction o) {
        return 0;
    }

    @Override
    public LocalTime getStartTime(String key) {
        Interval interval = getMap().get(key);
        if (interval != null) {
            return interval.getStartTime();
        }
        return null;
    }
}
