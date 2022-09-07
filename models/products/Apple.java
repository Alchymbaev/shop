package Lesson19.shop.models.products;

import Lesson19.shop.enums.Measure;
import Lesson19.shop.enums.ProductCategory;

public class Apple extends Product {
    public Apple(String name, double cost, Measure measure, ProductCategory productCategory) {
        super(name, cost, measure, productCategory);
    }
}
