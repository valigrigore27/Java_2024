import java.util.List;

public class Church extends Attraction implements Visitable{
    private List<String> visitingDays;
    private int startHour;
    private int endHour;

    public Church(String name){
        super(name);
    }

    public Church(String name, List<String> visitingDays, int startHour, int endHour) {
        super(name);
        this.visitingDays = visitingDays;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public void setVisitingDays(List<String> visitingDays) {
        this.visitingDays = visitingDays;
    }

    @Override
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    @Override
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Church{" +
                "visitingDays=" + visitingDays +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", name='" + name + '\'' +
                '}';
    }
}
