package sample;

import Domain.BMI;
import Domain.BP;
import Repo.Repo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BMI b1=new BMI("12.01.2019",12.3);
        BMI b2=new BMI("13.11.2019",11);
        BP b3=new BP("10.04.2019",90,120);
        BP b4=new BP("12.05.2019",80,110 );
        Repo repo= new Repo();
        repo.addObject(b1);
        repo.addObject(b2);
        repo.addObject(b3);
        repo.addObject(b4);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller(repo);
        loader.setController(controller);
        Parent root = (Parent)loader.load();


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
