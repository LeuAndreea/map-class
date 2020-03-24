package Domain;

public class Booking {
    private String id;
    private Route r;
    private String clientName;
    private int nbOfTickets;

    public Booking(String id, Route r, String clientName, int nbOfTickets) {
        this.id = id;
        this.r = r;
        this.clientName = clientName;
        this.nbOfTickets = nbOfTickets;
    }

    public String getId() {
        return id;
    }

    public Route getR() {
        return r;
    }

    public String getClientName() {
        return clientName;
    }

    public int getNbOfTickets() {
        return nbOfTickets;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setR(Route r) {
        this.r = r;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setNbOfTickets(int nbOfTickets) {
        this.nbOfTickets = nbOfTickets;
    }

    @Override
    public String toString() {
        return clientName + " " + nbOfTickets + "tickets :" + r;
    }
}
