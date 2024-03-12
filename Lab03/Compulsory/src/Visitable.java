import java.util.List;

public interface Visitable {
    default void setVisitingDays(List<String> visitingDays){

    }
    default void setStartHour(int startHour){

    }
    default void setEndHour(int endHour){

    }
}
