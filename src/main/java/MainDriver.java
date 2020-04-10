import Domain.*;
import Services.BookACab;

import java.util.ArrayList;
import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        Cab cab1=new Cab();
        Driver driver1=new Driver("d1",cab1);
        List<Driver> allAvailableDrivers=new ArrayList<>();

        allAvailableDrivers.add(driver1);


        Customer customer1=new Customer("c1");

        Destination destination=new Destination(12.5,77.5);
        Trip trip1= null;
        try {
            trip1 = new Trip(customer1,destination,2);
            customer1.setTrip(trip1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BookACab bookACab=new BookACab();
        System.out.println(" average rating of the customer "+customer1+" "+customer1.getAvgRating());
        System.out.println(bookACab.getListOfEligibleDrivers(allAvailableDrivers,customer1));


        trip1.setRatingtoCustomer(2);
        trip1.setRatingToDriver(1);

        customer1.getTrips().add(trip1);
        driver1.getTrips().add(trip1);
        System.out.println("Total number of requested rides by the customer"+customer1+" "+customer1.getTrips().size());

        driver1.getCab().setSeatsTaken(driver1.getCab().getSeatsTaken()-trip1.getSeats());





        Cab cab2=new Cab();
        Driver driver2=new Driver("d4",cab2);
        customer1.getNotEligible().put("d4",null);
        allAvailableDrivers.add(driver2);


        Destination destination2=new Destination(12.7,74.5);
        Trip trip2= null;
        try {
            trip2 = new Trip(customer1,destination2,2);
            customer1.setTrip(trip2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("###########################################");

        System.out.println(" average rating of the customer "+customer1+" "+customer1.getAvgRating());
        System.out.println(bookACab.getListOfEligibleDrivers(allAvailableDrivers,customer1));
        System.out.println("Total number of requested rides by the customer"+customer1.getTrips().size());

        trip2.setRatingtoCustomer(1);
        trip2.setRatingToDriver(2);


        System.out.println(" average rating of the customer "+customer1+" "+customer1.getAvgRating());





        Customer customer2=new Customer("c2");

        Destination destination3=new Destination(12.5,77.5);
        Trip trip3= null;
        try {
            trip3 = new Trip(customer2,destination3,2);
            customer2.setTrip(trip3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" average rating of the customer "+customer2+" "+customer2.getAvgRating());
        System.out.println(bookACab.getListOfEligibleDrivers(allAvailableDrivers,customer2));
        trip3.setRatingtoCustomer(5);
        trip3.setRatingToDriver(5);
        customer2.getTrips().add(trip3);
 //       driver1.getTrips().add(trip1);
        System.out.println("Total number of requested rides by the customer"+customer2+" "+customer2.getTrips().size());



    }

}
