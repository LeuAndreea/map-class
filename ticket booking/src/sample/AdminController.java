package sample;

import Domain.Booking;
import Repository.Repo;
import Service.Service;
import javafx.beans.InvalidationListener;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings( "deprecation" )
public class AdminController  implements Observer {
    private Service service;

    public AdminController(Service service) {
        this.service =service;
    }

    public AdminController(AdminController ctrl){
        this.service=ctrl.getService();
    }

    public void initialize(){

        this.refreshBookingList();
    }

    private void refreshBookingList() {
        Vector<Booking> bookings= this.service.getBookings().getObjects();

        ArrayList<Booking> sortedBookings = bookings.stream().sorted(Comparator.comparing(b -> b.getR().getAssoc().getSourceCity()))
                .sorted(Comparator.comparing(b -> b.getR().getDeparture())).collect(Collectors.toCollection(ArrayList::new));

        ObservableList<Booking> obs = FXCollections.observableArrayList(sortedBookings);

        this.bookingsView.getItems().clear();
        this.bookingsView.setItems(obs);
    }

    public Service getService() {
        return service;
    }



    @FXML
    protected ListView<Booking> bookingsView;

    @Override
    public void update(Observable o, Object arg) {
        this.refreshBookingList();

    }




}
