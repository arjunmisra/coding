package Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;


public interface Person {
    public String name = null;
    HashMap<String,String> notEligible = null;
    List<Trip> trips=null;
    public double getAvgRating();

}
