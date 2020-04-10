package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver implements Person {

    public String name;
    HashMap<String,String> notEligible=new HashMap<>();
    Cab cab;
    Trip trip;
    List<Trip> trips=new ArrayList<>();

    public Driver(String name, Cab cab){
        this.name=name;
        this.cab=cab;
    }
    @Override
    public double getAvgRating() {
        int sum=0;
        if(trips.size()==0)
            return 0;
        for(Trip trip: trips){
            sum+=trip.getRatingToDriver();
        }
        return sum/trips.size();
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, String> getNotEligible() {
        return this.notEligible;
    }

    public Cab getCab() {
        return this.cab;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public List<Trip> getTrips() {
        return this.trips;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotEligible(HashMap<String, String> notEligible) {
        this.notEligible = notEligible;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String toString(){
        return name+" "+getAvgRating();
    }
}
