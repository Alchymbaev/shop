package Lesson19.shop.models;

import Lesson19.shop.models.products.Product;

public class Details {
    private Product products;
    private int amount;
    private double discount;

    public Details(Product products, int amount, double discount) {
        this.products = products;
        this.amount = amount;
        this.discount = discount;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return products.getProductCategory().getCategoryName() + ": " + products.getName() +
                ", цена за 1 " + products.getMeasure().getMeasureName() + ": " + products.getCost() +
                ", количество: " + getAmount() + ", скидка на продукт: " + getDiscount() + "\n";
    }
}
