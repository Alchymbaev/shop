package Lesson19.shop;

import Lesson19.shop.enums.ProductCategory;
import Lesson19.shop.models.Cashier;
import Lesson19.shop.models.Details;
import Lesson19.shop.models.Order;
import Lesson19.shop.models.Receipt;
import Lesson19.shop.models.products.Product;
import Lesson19.shop.services.impl.OperationImpl;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать!!!");
        Scanner scanner = new Scanner(System.in);
        OperationImpl operation = new OperationImpl();
        ArrayList<Details> details = new ArrayList<>();
        while (true){
            System.out.println("Выберите категорию продуктов: ");
            operation.getProductCategory();
            System.out.print("Выберите категорию: ");
            String category = scanner.nextLine();
            ProductCategory productCategory = operation.getCategory(category);
            if (productCategory == null){
                continue;
            } else {
                while (true) {
                    System.out.println("Продукты выбранной категории: ");
                    operation.printListProductsByCategory(operation.getProductByCategory(productCategory));
                    System.out.print("Выберите продукт: ");
                    String selectedProduct = scanner.nextLine();
                    Product product = operation.getProductByName(selectedProduct);
                    if (product == null) {
                        continue;
                    } else {
                        System.out.print("Количество выбранного продукта: ");
                        int counts = operation.checkAmount(scanner.nextLine());
                        System.out.print("Скидка на продукт: ");
                        double discountSum = operation.checkDiscount(scanner.nextLine());
                        Details dtl = new Details(product, counts, discountSum);
                        details.add(dtl);
                    }
                    break;
                }  
            }
            System.out.print("Продолжаем? (да или нет): ");
            operation.checkAnswer(scanner.nextLine());
            if (operation.isAnswer()) {
                continue;
            } else {
                break;
            }
        }
        operation.printCashiers();
        System.out.print("Введите имя обслуживающего кассира: ");
        String cashier = scanner.nextLine();
        Cashier myCashier = operation.getCashier(cashier);
        Order order = new Order(myCashier, details);
        Receipt receipt = operation.getReceipt(order);
        System.out.println();
        System.out.println(order.toString());
        System.out.println(receipt.toString());
        System.out.println("\nСпасибо за покупку в нашем магазине!!!\nВсего доброго)))");
    }
}
