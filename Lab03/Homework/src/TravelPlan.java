import java.util.Map;

public class TravelPlan {
    private Map<String, Attraction> map;

    public TravelPlan() {
    }

    public TravelPlan(Map<String, Attraction> map) {
        this.map = map;
    }

    public Map<String, Attraction> getMap() {
        return map;
    }

    public void setMap(Map<String, Attraction> map) {
        this.map = map;
    }

    public void printTravelPlan() {
        for (Map.Entry<String, Attraction> entry : getMap().entrySet()) {
            String date  = entry.getKey();
            Attraction attraction = entry.getValue();
            System.out.println("On " + date + " visit: " + attraction.getName());
        }
    }
}
