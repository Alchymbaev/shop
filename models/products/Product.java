package Lesson19.shop.models.products;

import Lesson19.shop.enums.Measure;
import Lesson19.shop.enums.ProductCategory;

public abstract class Product {
    private String name;
    private double cost;
    private Measure measure;
    private ProductCategory productCategory;

    public Product(String name, double cost, Measure measure, ProductCategory productCategory) {
        this.name = name;
        this.cost = cost;
        this.measure = measure;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Measure getMeasure() {
        return measure;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
