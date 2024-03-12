import java.util.List;

public class Concert extends Attraction implements Visitable, Payable {
    private List<String> visitingDays;
    private int startHour;
    private int endHour;
    private int price;

    public Concert(String name){
        super(name);
    }
    public Concert(String name, List<String> visitingDays, int startHour, int endHour) {
        super(name);
        this.visitingDays = visitingDays;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
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
        return "Concert{" +
                "visitingDays=" + visitingDays +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
