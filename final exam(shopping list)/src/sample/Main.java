package sample;

import Service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Service s= new Service();
        Controller ctrl = new Controller(s);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(ctrl);
        Parent root = (Parent)loader.load();

        primaryStage.setTitle("Client1");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller user1ctrl = new Controller(s);
        loader2.setController(user1ctrl);
        Parent root2 = (Parent)loader2.load();

        Stage user1= new Stage();
        user1.setTitle("Client2");
        user1.setScene(new Scene(root2,300,275));

        user1.show();


        ctrl.addObserver(user1ctrl);
        user1ctrl.addObserver(ctrl);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
