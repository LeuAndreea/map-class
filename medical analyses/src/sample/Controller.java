package sample;

import Domain.BMI;
import Domain.BP;
import Domain.MedicalAnalysis;
import Repo.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {
    Repo analysis;

    @FXML
    private GridPane bmiMenu;

    @FXML
    private TextField bmiValue;

    @FXML
    private ListView<MedicalAnalysis> analysisView;

    @FXML
    private TextField dateTextBox;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private GridPane bpMenu;

    @FXML
    private TextField systolicValue;

    @FXML
    private TextField diastolicValue;

    @FXML
    private Button continueButton;

    @FXML
    private Button addButton;

    @FXML
    private Button healthButton;

    @FXML
    private TextField healthyTextBox;


    public Controller(Repo analysis) {
        this.analysis = analysis;
    }

    @FXML
    void showMenu(ActionEvent event) {
        if (this.typeChoiceBox.getValue()==null){
            Alert a= new Alert(Alert.AlertType.WARNING);
            a.setContentText("You selected nothing!");
            a.show();
        }
        else {
            this.addButton.setVisible(true);

            if (this.typeChoiceBox.getValue() == "BMI") {
                this.bmiMenu.setVisible(true);
            } else
                this.bpMenu.setVisible(true);
        }
    }

    boolean checkDate(String date){
        if (Integer.parseInt(date.substring(0,3))<1 || Integer.parseInt(date.substring(0,3))>31) {
            return false;
        }
        return Integer.parseInt(date.substring(3, 5)) >= 1 && Integer.parseInt(date.substring(0, 3)) <= 12;

    }

    @FXML
    void addNewAnalysis(ActionEvent event) {
        String date= this.dateTextBox.getText();


        if (this.typeChoiceBox.getValue()=="BMI"){
            double value= Double.parseDouble(this.bmiValue.getText());
            BMI b=new BMI(date,value);

            this.analysis.addObject(b);

            this.bmiMenu.setVisible(false);

        }
        else{
                int systolicValue= Integer.parseInt(this.systolicValue.getText());
                int diastolicValue= Integer.parseInt(this.diastolicValue.getText());
                BP b=new BP(date,systolicValue,diastolicValue);

                this.analysis.addObject(b);

                this.bpMenu.setVisible(false);
        }

        this.addButton.setVisible(false);

        this.printList();
    }



    @FXML
    void isHealthy(ActionEvent event) {
        Calendar now = Calendar.getInstance();

        int month= now.get(Calendar.MONTH)+1;


        ArrayList<MedicalAnalysis> analyses=new ArrayList<>(this.analysis.getObjects());


        boolean healthy= analyses.stream().filter(a-> a.getMonth()==month || a.getMonth()==month-1)
                    .allMatch(a-> a.isResultOK()==true);

        if (healthy==true)
            this.healthyTextBox.setText("YES!");
        else
            this.healthyTextBox.setText("NO :(");
    }

    @FXML
    public void initialize() {


        System.out.println("FUCK.!");
        typeChoiceBox.getItems().add("BMI");
        typeChoiceBox.getItems().add("BP");

        this.printList();


    }

    @FXML
    public void printList(){
        ArrayList<MedicalAnalysis> analyses=new ArrayList<>(this.analysis.getObjects());
        ObservableList<MedicalAnalysis> obsAnalyses = FXCollections.observableArrayList(analyses);
        this.analysisView.setItems(obsAnalyses);
    }


    /*public void writeToFile(){



        BufferedWriter bw= null;
        try {
            bw = new BufferedWriter(new FileWriter("out.txt"));
            for (Object o: objects)
            {
                bw.write(o.toString());
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
    }*/


}



