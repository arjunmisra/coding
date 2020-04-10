package Domain;

import java.util.ArrayList;
import java.util.List;
public class Cab {
    final static int MAX_SEATS=4;
    List<Customer> customerList=new ArrayList<>();
    int seatsTaken;

    public Cab() {
    }

    public int seatsAvailableInCab(){
        return MAX_SEATS-seatsTaken;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public int getSeatsTaken() {
        return this.seatsTaken;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }
}
