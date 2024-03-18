import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trip {
    private List<Attraction> attractions;

    public Trip(){

    }
    public Trip(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
    public void displayVisitableNonPayable() {
        List<Attraction> visitableNonPayableAttractions = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNonPayableAttractions.add(attraction);
            }
        }

        visitableNonPayableAttractions.sort(Comparator.comparing(attraction -> {
            Interval<?> interval = attraction.getMap().values().iterator().next();
            return interval.getStartTime();
        }));

        for (Attraction attraction : visitableNonPayableAttractions) {
            System.out.println(attraction);
        }
    }


}
