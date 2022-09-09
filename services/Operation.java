package Lesson19.shop.services;

import Lesson19.shop.enums.ProductCategory;
import Lesson19.shop.models.Cashier;
import Lesson19.shop.models.Order;
import Lesson19.shop.models.Receipt;
import Lesson19.shop.models.products.Product;

import java.util.ArrayList;

public interface Operation {
    void getProductCategory();

    ProductCategory getCategory();

    ArrayList<Product> getProductByCategory(ProductCategory productCategory);

    void printListProductsByCategory(ArrayList<Product> list);

    Product getProductByName();

    Receipt getReceipt(Order order);

    Cashier getCashier();

    boolean checkAnswer();

    double checkDiscount(Product product);

    int checkAmount();

    void printCashiers();
}
