package DOMAIN;

public class Product {
    private String id;
    private String brand;
    private String name;
    private Double price;
    private int quantity;

    public Product(String id, String brand, String name, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String product=  id + " :" +
                brand + ' '
                 + name + ' ' +
                 price + "ron ,";


        if (quantity== 0)
            product += "out of stock :(.";
        else
            product+= quantity + "left";
        return product;

    }

}