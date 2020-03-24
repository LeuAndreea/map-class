package sample;



import DOMAIN.Product;
import DOMAIN.ShoppingBasketItem;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

@SuppressWarnings( "deprecation" )
public class Controller extends Observable implements Observer {

    ArrayList<ShoppingBasketItem> shoppingBasketItems;
    Service s;

    public Controller(Service s) {
        shoppingBasketItems = new ArrayList<ShoppingBasketItem>();

        this.s = s;
    }

    public void initialize() {
        this.populateProductList();

    }

    @Override
    public void update(Observable o, Object arg) {
        this.populateProductList();
    }


    @FXML
    private Label priceLabel;
    @FXML
    private ListView<Product> productList;

    @FXML
    private ListView<ShoppingBasketItem> shoppingBasketList;

    @FXML
    private TextField quantityField;

    @FXML
    private Button buyButton;

    @FXML
    void productBought(ActionEvent event) {

        int quantity = 0;

        if (this.quantityField.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please introduce a valid quantity!");
            a.show();
        }

        try {
            quantity = Integer.parseInt(quantityField.getText());


        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please introduce a valid quantity!");
            a.show();

            return;
        }


        Product p = this.productList.getSelectionModel().getSelectedItem();

        if (p.getQuantity() < quantity) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("not eonugh stock!");
            a.show();

            return;
        }


        ShoppingBasketItem item = new ShoppingBasketItem(p, quantity);
        this.shoppingBasketItems.add(item);

        //setting product quantity
        p.setQuantity(p.getQuantity() - quantity);

        //repopulating list
        this.populateProductList();
        this.populateShoppingBasket();
        //writing to file
        this.s.writeToFile();

        setChanged();
        notifyObservers();

    }

    private void populateShoppingBasket() {
        double price= 0;
        for (ShoppingBasketItem item: shoppingBasketItems){
            price+= item.getP().getPrice() * item.getQuantity();
        }

        this.priceLabel.setText(Double.toString(price));
        ObservableList<ShoppingBasketItem> obs = FXCollections.observableArrayList(shoppingBasketItems);
        this.shoppingBasketList.setItems(obs);
    }

    private void populateProductList() {
        ObservableList<Product> obs = FXCollections.observableArrayList(s.getProducts());
        this.productList.setItems(obs);
    }

    @FXML
    private TextField stringField;

    @FXML
    private TextField pirceAboveField;

    @FXML
    private TextField priceBelowField;

    @FXML
    private Button searchButton;

    @FXML
    void filterProducts(ActionEvent event) {

        ArrayList<Product> products = new ArrayList<>(this.s.getProducts());

        if (!this.priceBelowField.getText().equals("")) {
            ArrayList<Product> filtered = products.stream()
                    .filter(p -> p.getPrice() < Double.parseDouble(this.priceBelowField.getText())).collect(Collectors.toCollection(ArrayList::new));

            products = filtered;
        }

        if (!(this.pirceAboveField.getText().equals(""))) {
            ArrayList<Product> filtered = products.stream()
                    .filter(p -> p.getPrice() > Double.parseDouble(this.pirceAboveField.getText())).collect(Collectors.toCollection(ArrayList::new));

        }

        if (!(this.stringField.getText().equals(""))) {
            products = this.s.getProducts().stream()
                    .filter(p -> p.getName().contains(this.stringField.getText())).collect(Collectors.toCollection(ArrayList::new));



        }

        ObservableList<Product> obs = FXCollections.observableArrayList(products);
        this.productList.setItems(obs);
    }
}
