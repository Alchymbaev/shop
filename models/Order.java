package Lesson19.shop.models;

import java.util.ArrayList;

public class Order {
    private Cashier cashier;
    private ArrayList<Details> details;

    public Order(Cashier cashier, ArrayList<Details> details) {
        this.cashier = cashier;
        this.details = details;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public ArrayList<Details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Details> details) {
        this.details = details;
    }

    private String printAllProducts(){
        String printing = "";
        for (Details prod : details) {
            printing += prod.toString();
        }
        return printing;
    }

    @Override
    public String toString() {
        return "      Ваш чек\n" + cashier.toString() + "\n" + printAllProducts();
    }
}
