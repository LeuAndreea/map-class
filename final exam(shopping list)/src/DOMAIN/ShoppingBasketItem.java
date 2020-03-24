package DOMAIN;

public class ShoppingBasketItem {
    private Product p;
    private int quantity;

    public ShoppingBasketItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }

    public Product getP() {
        return p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return p + "quantity bought: " + quantity;
    }
}