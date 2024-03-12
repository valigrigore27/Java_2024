import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        List<String> listOfDays= new ArrayList<>();
        listOfDays.add("Monday");
        listOfDays.add("Wednesday");
        listOfDays.add("Saturday");


        Concert concert = new Concert("Andrea Bocelli");
        concert.setVisitingDays(listOfDays);
        concert.setStartHour(19);
        concert.setEndHour(21);
        concert.setPrice(1827);

        Church church = new Church("St. Mary");
        church.setVisitingDays(listOfDays);
        church.setStartHour(12);
        church.setEndHour(15);


        Statue statue = new Statue("Liberty");

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(concert);
        attractions.add(church);
        attractions.add(statue);




        Trip trip = new Trip("Bucharest", 8, 20, attractions);
        trip.displayAttractions();
    }
}
