package Lesson19.shop.services.impl;

import Lesson19.shop.enums.Measure;
import Lesson19.shop.enums.ProductCategory;
import Lesson19.shop.models.Cashier;
import Lesson19.shop.models.Details;
import Lesson19.shop.models.Order;
import Lesson19.shop.models.Receipt;
import Lesson19.shop.models.products.*;
import Lesson19.shop.services.Operation;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationImpl implements Operation {
    Scanner scanner = new Scanner(System.in);
    Product apple = new Apple("Яблоко", 50.5, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product banana = new Banana("Банан", 98.3, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product orange = new Orange("Апельсин", 120.8, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product milk = new Milk("Молоко", 40, Measure.LITER, ProductCategory.DAIRYPRODUCT);
    Product kefir = new Kefir("Кефир", 55.5, Measure.LITER, ProductCategory.DAIRYPRODUCT);
    Product yogurt = new Yogurt("Йогурт", 30.7, Measure.THING, ProductCategory.DAIRYPRODUCT);
    Product pie = new Pie("Пирог", 190.3, Measure.THING, ProductCategory.DESSERT);
    Product icecream = new IceCream("Мороженое", 19.3, Measure.THING, ProductCategory.DESSERT);
    Product cake = new Cake("Торт", 800.4, Measure.THING, ProductCategory.DESSERT);
    Product[] products = new Product[] {apple, banana, orange, milk, kefir, yogurt,pie, cake, icecream};

    Cashier cashier1 = new Cashier("Алман", "silma");
    Cashier cashier2 = new Cashier("Илим", "kalman");

    Cashier[] cashiers = new Cashier[] {cashier1, cashier2};

    @Override
    public void getProductCategory() {
        for (ProductCategory categories : ProductCategory.values()) {
            System.out.println("   " + categories.getCategoryName());
        }
    }

    @Override
    public ProductCategory getCategory() {
        System.out.print("Выберите категорию: ");
        String name = scanner.nextLine();
        ProductCategory myCategory = null;
        for (ProductCategory category : ProductCategory.values()) {
            if (category.getCategoryName().equals(name)) {
                myCategory = category;
            }
        }
        return myCategory;
    }

    @Override
    public ArrayList<Product> getProductByCategory(ProductCategory productCategory) {
        ArrayList<Product> productByCategory = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductCategory() == productCategory){
                productByCategory.add(products[i]);
            }
        }
        return productByCategory;
    }

    @Override
    public void printListProductsByCategory(ArrayList<Product> list) {
        for (Product prd : list) {
            System.out.println("   " + prd.getName() + ", цена за 1" + prd.getMeasure().getMeasureName() + " : " + prd.getCost());
        }
    }

    @Override
    public Product getProductByName() {
        System.out.print("Выберите продукт: ");
        String selectedProduct = scanner.nextLine();
        Product product = null;
        for (Product prd : products) {
            if (prd.getName().equals(selectedProduct)){
                product = prd;
            }
        }
        return product;
    }

    @Override
    public Receipt getReceipt(Order order) {
        double totalSum = 0;
        double totalDiscount = 0;
        for (Details dtl : order.getDetails()) {
            totalSum += dtl.getProducts().getCost() * dtl.getAmount();
            totalDiscount += dtl.getDiscount() * dtl.getAmount();
        }
        return new Receipt(totalSum, totalDiscount);
    }

    @Override
    public Cashier getCashier() {
        printCashiers();
        System.out.print("Введите имя обслуживающего кассира: ");
        String selectedCashier = scanner.nextLine();
        Cashier myCashier = null;
        for (Cashier chr : cashiers) {
            if (chr.getName().equals(selectedCashier)){
                myCashier = chr;
            }
        }
        if (myCashier != null) {
            return myCashier;
        } else {
            return getCashier();
        }
    }

    @Override
    public void printCashiers(){
        System.out.println("Кассиры: ");
        for (int i = 0; i < cashiers.length; i++) {
            System.out.println("   " + (i+1) + ") " + cashiers[i].getName());
        }
    }

    @Override
    public int checkAmount() {
        System.out.print("Количество выбранного продукта: ");
        String str = scanner.nextLine();
        if (isNumber(str) && Integer.parseInt(str) > 0){
            return Integer.parseInt(str);
        } else {
            return checkAmount();
        }
    }

    private boolean isNumber(String str){
        if (!str.matches("[0-9]+")){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double checkDiscount(Product product) {
        System.out.print("Скидка на продукт: ");
        String str = scanner.nextLine();
        try {
            if (Double.parseDouble(str) < 100 && Double.parseDouble(str) >= 0)
                return (product.getCost() * Double.parseDouble(str)) / 100;
            else {
                return checkDiscount(product);
            }
        } catch (NumberFormatException e) {
            return checkDiscount(product);
        }
    }

    @Override
    public boolean checkAnswer() {
        System.out.print("Продолжаем? (да или нет): ");
        String str = scanner.nextLine();
        if (str.equals("да") || str.equals("Да") || str.equals("ДА")) {
            return  true;
        } else if (str.equals("нет") || str.equals("Нет") || str.equals("НЕТ")) {
            return false;
        } else {
            return checkAnswer();
        }
    }
}
