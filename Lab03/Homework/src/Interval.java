import java.time.LocalTime;
import java.util.Objects;

public class Interval<T extends LocalTime> {
    private T startTime;
    private T endTime;

    public Interval(T startTime, T endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public T getStartTime() {
        return startTime;
    }

    public T getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }

}
