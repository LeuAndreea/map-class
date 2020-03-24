package Service;

import Domain.Booking;
import Domain.SourceDestAssoc;
import Repository.Repo;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Service {
    private Repo bookings,routes,assoc;


    public Service(Repo bookings, Repo routes,Repo assoc) {
        this.bookings = bookings;
        this.routes = routes;
        this.assoc= assoc;
    }

    public Repo getBookings() {
        return bookings;
    }

    public Repo getRoutes() {
        return routes;
    }

    public Repo getAssoc() {
        return assoc;
    }

    public void addBooking(Booking b){ this.bookings.addObject(b);}

    /*public Vector<Route> findRoutes(String sourceCityId){
        Vector<Route> routes=this.getRoutes().getObjects();

        for (Route r: routes){
            if (!(r.get().getSourceCityId().equals(sourceCityId)))
                routes.remove(r);
        }

        return routes;

    }*/

    public Vector<SourceDestAssoc> findDestination(String sourceCity) {
        Vector<SourceDestAssoc> assoc = this.getAssoc().getObjects();
        for (SourceDestAssoc a: assoc)
            if (!a.getSourceCity().equals(sourceCity))
                assoc.remove(a);

        return assoc;
    }

    public void sortBookings(){



    }
}



