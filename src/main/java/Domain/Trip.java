package Domain;

public class Trip {

    Driver driver;
    Customer customer;
    Destination destination;
    int seats;
    int ratingtoCustomer=0;
    int ratingToDriver=0;

    public Trip(Customer customer, Destination destination,int seats) throws Exception {
        this.customer=customer;
        this.destination=destination;
        if(seats>=0 && seats<=2)
            this.seats=seats;
        else
            throw new Exception("You have requested for invalid seats");
    }



    public Driver getDriver() {
        return this.driver;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public int getSeats() {
        return this.seats;
    }

    public int getRatingtoCustomer() {
        return this.ratingtoCustomer;
    }

    public int getRatingToDriver() {
        return this.ratingToDriver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setRatingtoCustomer(int ratingtoCustomer) {
        this.ratingtoCustomer = ratingtoCustomer;
    }

    public void setRatingToDriver(int ratingToDriver) {
        this.ratingToDriver = ratingToDriver;
    }
}
