package sample;

import Domain.Equation;
import Domain.FirstDegreeEquation;
import Domain.SecondDegreeEquation;
import Repository.Repo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Vector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Repo repo=new Repo();

        Vector<Double> c1= new Vector();
        c1.add((double) 3);
        c1.add((double) 2);
        Equation e= new FirstDegreeEquation(c1);
        repo.addObject(e);

        Vector<Double> c2= new Vector();
        c2.add((double) 6);
        c2.add((double) 11);
        c2.add((double) 0);
        Equation e2= new SecondDegreeEquation(c2);
        repo.addObject(e2);

        Vector<Double> c3= new Vector();
        c3.add((double) 9);
        c3.add((double) -21);
        c3.add((double) 0);
        Equation e3= new SecondDegreeEquation(c3);
        repo.addObject(e3);

        Vector<Double> c4= new Vector();
        c4.add((double) 7);
        c4.add((double) -21);
        c4.add((double) 4);
        Equation e4= new SecondDegreeEquation(c4);
        repo.addObject(e4);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller(repo);
        loader.setController(controller);
        Parent root = (Parent)loader.load();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
