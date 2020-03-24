package sample;

import Domain.Equation;
import Domain.SecondDegreeEquation;
import Repository.Repo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

public class Controller {
    Repo equations;

    Controller(Repo repo){
        this.equations=repo;
    }

    public void initialize(){
        this.printList();
    }

    public void printList(){

        ArrayList<Equation> equations=new ArrayList<>(this.equations.getObjects());
        ObservableList<Equation> obsEq = FXCollections.observableArrayList(equations);
        this.equationList.setItems(obsEq);
    }


    @FXML
    private ListView<Equation> equationList;

    @FXML
    private ListView<Double> resultView;

    @FXML
    private Button computeButton;

    @FXML
    private Button showConstantTerm0;

    @FXML
    private TextField fileOutTextField;

    @FXML
    void computeSolution(ActionEvent event) {
        Equation eq=this.equationList.getSelectionModel().getSelectedItem();

        Vector<Double> sol=eq.getSolutions();

        ArrayList<Double> equations=new ArrayList<Double>(sol);
        ObservableList<Double> obsEq = FXCollections.observableArrayList(equations);
        this.resultView.setItems(obsEq);

    }

    @FXML
    void showConstantTerm0(ActionEvent event) {

        String text= this.fileOutTextField.getText();

        ArrayList<Equation> equations=new ArrayList<>(this.equations.getObjects());
        List<Equation> result= equations.stream().filter(e-> e instanceof SecondDegreeEquation).filter(e->e.getCoefficients().elementAt(2)==0).collect(Collectors.toList());
        this.writeToFile(result,text);

    }

    public void writeToFile(List<Equation> eq,String filename){

        Vector<String> results= new Vector();
        for (int i=0; i<eq.size(); i++){
            String a= eq.get(i).toString() + "Solutions: " + eq.get(i).getSolutions();
            results.add(a);
        }

        BufferedWriter bw= null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
            for (String o: results)
            {
                bw.write(o);
                bw.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try
            {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
