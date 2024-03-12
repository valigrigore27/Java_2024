import java.util.Collections;
import java.util.List;

public class Trip {
    private String nameOfCity;
    private int startTime;
    private int endTime;
    private List<Attraction> attractions;

    public Trip(String nameOfCity, int startTime, int endTime, List<Attraction> attractions) {
        this.nameOfCity = nameOfCity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attractions = attractions;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
    public void displayAttractions() {
        Collections.sort(attractions);
        for (Attraction attraction : attractions) {
            //attraction.getName().compareTo();
            System.out.println(attraction);
        }
    }

    @Override
    public String toString() {
        return "Trip{" +
                "nameOfCity='" + nameOfCity + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", attractions=" + attractions +
                '}';
    }
}
