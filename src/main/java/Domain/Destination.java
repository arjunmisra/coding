package Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destination {
    double lat;
    double lng;

    public Destination(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
