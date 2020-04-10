package Domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer implements Person {

    public String name;
    HashMap<String,String> notEligible=new HashMap<>();
    Trip trip;
    List<Trip> trips=new ArrayList<>();

    public Customer(String name) {
        this.name=name;
    }

    @Override
    public double getAvgRating() {
        int sum=0;
        if(trips.size()==0)
            return 0;
        for(Trip prevtrip: trips){
            sum+=prevtrip.getRatingtoCustomer();
        }
        return sum/trips.size();
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, String> getNotEligible() {
        return this.notEligible;
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

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
