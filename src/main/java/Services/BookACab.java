package Services;

import Domain.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class BookACab {

    public boolean checkIfSeatsAvailable(Cab cab, Trip trip){
        if(cab.seatsAvailableInCab()-trip.getSeats()>=0)
            return true;
        return false;

    }

    public boolean checkIfDistanceIsUnderThreshold(Cab cab, Trip trip){

        List<Customer> customers=cab.getCustomerList();
        if(customers.size()==0)
            return true;
        for(Customer customer:customers){
            if(checkDistanceThreshold(customer.getTrip().getDestination(),trip.getDestination()));
                return true;
        }
        return false;
    }

    public boolean checkDistanceThreshold(Destination customerDestination,Destination requestDestination){
        double x1=customerDestination.getLat();
        double y1=customerDestination.getLng();
        double x2=requestDestination.getLat();
        double y2=requestDestination.getLng();
        double dist=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        if(dist<=5)
            return true;
        return false;
    }

    //mandatory checks cancellation and 1 star
    public boolean checkIfTheDriverIsEligible(Driver driver,Customer customer){
        if(driver.getNotEligible().containsKey(customer.getName()))
            return false;
        if(customer.getNotEligible().containsKey(driver.getName()))
            return false;

        return true;

    }

    public boolean validateTheAverageRating(Driver driver, Customer customer){
        if(driver.getAvgRating()>=customer.getAvgRating())
            return true;
        return false;

    }

    public List<Driver> getListOfHistoricalDriversFromCustomer(Customer customer){
         List<Trip> trips=customer.getTrips();
         List<Driver> driversList=new ArrayList<>();
         for(Trip trip:trips){
             driversList.add(trip.getDriver());
         }
         return driversList;

    }

    public List<Driver> getListOfEligibleDrivers(List<Driver> listOfAvailableDrivers,Customer customer){
        List<Driver> eligibleDrivers=new ArrayList<>();
        Trip trip=customer.getTrip();
        for(Driver driver:listOfAvailableDrivers){
            Cab cab=driver.getCab();
            if(checkIfSeatsAvailable(cab,trip) && checkIfDistanceIsUnderThreshold(cab,trip) && checkIfTheDriverIsEligible(driver,customer)){
                if(validateTheAverageRating(driver,customer)){
                    eligibleDrivers.add(driver);
                }
//                else{
//                    List<Driver> historicalDriversFromCustomer=getListOfHistoricalDriversFromCustomer(customer);
//                    List<Driver> eligibleHistoricalDrivers=getListOfEligibleDrivers(historicalDriversFromCustomer,customer);
//                    for(Driver historicalDriver:eligibleHistoricalDrivers){
//                        eligibleDrivers.add(historicalDriver);
//                    }
//
//                }
            }

        }

        return eligibleDrivers;
    }
}
