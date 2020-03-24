package sample;

import Domain.Booking;
import Domain.Route;
import Domain.SourceDestAssoc;
import Repository.Repo;
import Service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalTime;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //populating




        //populating routes repository
        SourceDestAssoc a1=new SourceDestAssoc ("AAA","Campia Turzii","Cluj-Napoca");
        SourceDestAssoc a2=new SourceDestAssoc ("BCA","Campia Turzii","Deva");

        Repo assoc = new Repo();
        assoc.addObject(a1);
        assoc.addObject(a2);

        Route r1= new Route("96Y",a1,LocalTime.of(12,30),LocalTime.of(13,30),30,7.5 );
        Route r2= new Route("D60",a2,LocalTime.of(13,30),LocalTime.of(14,45),100,37);
        Route r3= new Route("9G4",a2,LocalTime.of(4,25),LocalTime.of(10,45),43,30);
       // Route r4= new Route("4VM");
        //Route r5= new Route("5KT");

        Repo routes= new Repo();
        routes.addObject(r1);
        routes.addObject(r2);
        routes.addObject(r3);
        //routes.addObject(r2);
        //routes.addObject(r3);
        //routes.addObject(r4);
        //routes.addObject(r5);


        //populating bookings repository
        Booking b1= new Booking("52U",r1,"Leu Andreea",5);
        //Booking b2= new Booking();
        //Booking b3= new Booking();
        //Booking b4= new Booking();
        //Booking b5= new Booking();

        Repo bookings = new Repo();
        bookings.addObject(b1);
        //bookings.addObject(b);
        //bookings.addObject(b);
        //bookings.addObject(b);
        //bookings.addObject(b);

        Service s= new Service(bookings,routes,assoc);


        //initializing admin window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
        AdminController adminctrl = new AdminController(s);
        loader.setController(adminctrl);
        Parent root = (Parent)loader.load();


        primaryStage.setTitle("ADMIN");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //setting up first user
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("user.fxml"));
        UserController user1ctrl = new UserController(s,"Leu Andreea");
        loader2.setController(user1ctrl);
        Parent root2 = (Parent)loader2.load();

        Stage user1= new Stage();
        user1.setTitle("Leu Andreea");
        user1.setScene(new Scene(root2,300,275));

        user1.show();

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("user.fxml"));
        UserController user2ctrl = new UserController(s,"Mereu Andrada");
        loader3.setController(user2ctrl);
        Parent root3 = (Parent)loader3.load();

        Stage user2= new Stage();
        user2.setTitle("Mereu Andrada");
        user2.setScene(new Scene(root3,300,275));

        user2.show();


        //adminctrl.addObserver(user1ctrl);
        user1ctrl.addObserver(adminctrl);
        user2ctrl.addObserver(adminctrl);








    }


    public static void main(String[] args) {
        launch(args);
    }
}
