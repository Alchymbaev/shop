package Lesson19.shop;

import Lesson19.shop.enums.ProductCategory;
import Lesson19.shop.models.Cashier;
import Lesson19.shop.models.Details;
import Lesson19.shop.models.Order;
import Lesson19.shop.models.Receipt;
import Lesson19.shop.models.products.Product;
import Lesson19.shop.services.impl.OperationImpl;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать!!!");
        OperationImpl operation = new OperationImpl();
        ArrayList<Details> details = new ArrayList<>();
        while (true){
            System.out.println("Выберите категорию продуктов: ");
            operation.getProductCategory();
            ProductCategory productCategory = operation.getCategory();
            if (productCategory == null){
                continue;
            } else {
                while (true) {
                    System.out.println("Продукты выбранной категории: ");
                    operation.printListProductsByCategory(operation.getProductByCategory(productCategory));
                    Product product = operation.getProductByName();
                    if (product == null) {
                        continue;
                    } else {
                        int counts = operation.checkAmount();
                        double discountSum = operation.checkDiscount(product);
                        Details dtl = new Details(product, counts, discountSum);
                        details.add(dtl);
                    }
                    break;
                }
            }
            if (!operation.checkAnswer()) {
                break;
            }
        }
        Cashier myCashier = operation.getCashier();
        Order order = new Order(myCashier, details);
        Receipt receipt = operation.getReceipt(order);
        System.out.println();
        System.out.println(order.toString());
        System.out.println(receipt.toString());
        System.out.println("\nСпасибо за покупку в нашем магазине!!!\nВсего доброго)))");
    }
}
