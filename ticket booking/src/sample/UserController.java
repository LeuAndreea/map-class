package sample;

import Domain.Booking;
import Domain.Route;
import Domain.SourceDestAssoc;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.*;


@SuppressWarnings( "deprecation" )
public class UserController extends Observable {
    Service service;
    private String name;

    public UserController(Service service, String name) {
        this.service = service;
        this.name = name;
    }

    public void initialize(){
        this.refreshSourceCityList();

   }



    @FXML
    private ListView<String> sourceCityView;

    @FXML
    private ListView<Route> routesView;

    @FXML
    private ListView<String> destinationCityView;

    @FXML
    private TextField nbOfTicketsInput;

    @FXML
    private Button bookButton;

    @FXML
    private Label priceLabel;

    private void refreshSourceCityList() {
        Vector<SourceDestAssoc> assoc = this.service.getAssoc().getObjects();
        Vector<String> sourceCities= new Vector<String>();

        for (SourceDestAssoc a: assoc ){
            sourceCities.add(a.getSourceCity());
        }

        Set<String> set = new HashSet<String>();
        set.addAll(sourceCities);
        sourceCities.clear();
        sourceCities.addAll(set);

        for (String s: sourceCities){
            this.sourceCityView.getItems().add(s);
        }
    }

    private void refreshDestinationCityList() {
        String sourceCity = this.sourceCityView.getSelectionModel().getSelectedItem();

        this.destinationCityView.getItems().clear();
        Vector<SourceDestAssoc> assoc = this.service.getAssoc().getObjects();
        for (SourceDestAssoc a: assoc ){
            if (a.getSourceCity().equals(sourceCity))
                this.destinationCityView.getItems().add(a.getDestinationCity());
        }
    }

    private void refreshRouteView() {
        String sourceCity = this.sourceCityView.getSelectionModel().getSelectedItem();
        String destinationCity = this.destinationCityView.getSelectionModel().getSelectedItem();

        String assocId= "";

        Vector<SourceDestAssoc> assoc = this.service.getAssoc().getObjects();
        for (SourceDestAssoc a: assoc){
            if (a.getSourceCity().equals(sourceCity) && a.getDestinationCity().equals(destinationCity))
                assocId= a.getId();
        }


        this.routesView.getItems().clear();
        Vector<Route> routes = this.service.getRoutes().getObjects();
        for (Route r: routes)
            if (r.getAssoc().getId().equals(assocId))
                this.routesView.getItems().add(r);
    }

    @FXML
    void destinationSelected(MouseEvent event) {
        this.refreshRouteView();
    }




    @FXML
    void bookingSelected(ActionEvent event) {
        Route r= this.routesView.getSelectionModel().getSelectedItem();

        Booking b= new Booking("b67",r, this.name,  Integer.parseInt(this.nbOfTicketsInput.getText()));
        this.service.addBooking(b);

        r.setNbOfSeats(r.getNbOfSeats()-b.getNbOfTickets());
        this.refreshRouteView();

        setChanged();
        notifyObservers();
    }

    @FXML
    void citySelected(MouseEvent event) {
            this.refreshDestinationCityList();
    }



    @FXML
    void updatePrice(KeyEvent event) {

        double price=this.routesView.getSelectionModel().getSelectedItem().getPrice();
        double quantity= Integer.parseInt(this.nbOfTicketsInput.getText());

        this.priceLabel.setText(Double.toString(price*quantity));
    }

}
