package Lesson19.shop.models.products;

import Lesson19.shop.enums.Measure;
import Lesson19.shop.enums.ProductCategory;

public class Yogurt extends Product {
    public Yogurt(String name, double cost, Measure measure, ProductCategory productCategory) {
        super(name, cost, measure, productCategory);
    }
}
