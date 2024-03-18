import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {

    public Concert(String name){
        super(name);
    }
    public Concert(String name, Map<String, Interval> map) {
        super(name, map);
    }

    @Override
    public void setPrice(int price) {

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
