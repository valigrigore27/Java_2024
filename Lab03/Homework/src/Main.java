import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Attraction statue = new Statue("Stefan cel Mare");
        Attraction church = new Church("Catolica");
        Attraction concert = new Concert("Stefan Banica");
        //statue.setMap();
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(statue);
        attractions.add(church);
        attractions.add(concert);


        Map<String, Attraction> travelPlanMap = new HashMap<>();
        travelPlanMap.put("2024-03-14", statue);
        travelPlanMap.put("2024-03-15", church);
        travelPlanMap.put("2024-03-16", concert);

        Trip trip = new Trip(attractions);


        TravelPlan travelPlan = new TravelPlan(travelPlanMap);
        travelPlan.printTravelPlan();

        trip.displayVisitableNonPayable();
    }
}