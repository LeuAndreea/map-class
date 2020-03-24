package Domain;

import java.time.LocalTime;
import java.util.Objects;

public class Route {
    private String id;
    private SourceDestAssoc assoc;
    private LocalTime departure;
    private LocalTime arrival;
    private int nbOfSeats;
    private double price;

    public Route(String id,SourceDestAssoc assoc, LocalTime departure, LocalTime arrival, int nbOfSeats, double price) {
        this.id=id;
        this.assoc=assoc;
        this.departure=departure;
        this.arrival = arrival;
        this.nbOfSeats = nbOfSeats;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public SourceDestAssoc getAssoc() {
        return assoc;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public int getNbOfSeats() {
        return nbOfSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAssoc(SourceDestAssoc assoc) {
        this.assoc = assoc;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    public void setNbOfSeats(int nbOfSeats) {
        this.nbOfSeats = nbOfSeats;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return assoc +"DEPARTUrE:" + departure +
                "ARRIVAL:" + arrival +
                ", price=" + price;
    }


}
