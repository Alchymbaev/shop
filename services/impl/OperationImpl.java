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
    private boolean answer;
    Scanner scanner = new Scanner(System.in);
    Product apple = new Apple("Яблоко", 50.5, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product banana = new Banana("Банан", 98.3, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product orange = new Orange("Апельсин", 120.8, Measure.KILOGRAMM, ProductCategory.FRUIT);
    Product milk = new Milk("Молоко", 40, Measure.LITER, ProductCategory.DAIRYPRODUCT);
    Product kefir = new Kefir("Кефир", 55.5, Measure.LITER, ProductCategory.DAIRYPRODUCT);
    Product yogurt = new Yogurt("Йогурт", 30.7, Measure.THING, ProductCategory.DAIRYPRODUCT);

    Product cake = new Cake("Торт", 800.4, Measure.THING, ProductCategory.DESSERT);
    Product[] products = new Product[] {apple, banana, orange, milk, kefir, yogurt, cake};

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
    public ProductCategory getCategory(String name) {
        for (ProductCategory category : ProductCategory.values()) {
            if (category.getCategoryName().equals(name)) {
                return category;
            }
        }
        return null;
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
    public Product getProductByName(String selectedProduct) {
        for (Product prd : products) {
            if (prd.getName().equals(selectedProduct)){
                return prd;
            }
        }
        return null;
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
    public Cashier getCashier(String name) {
        for (Cashier cshr : cashiers) {
            if (cshr.getName().equals(name)){
                return cshr;
            }
        }
        System.out.print("Попробуйте ещё раз: ");
        getCashier(scanner.nextLine());
        return null;
    }

    public void printCashiers(){
        System.out.println("Кассиры: ");
        for (int i = 0; i < cashiers.length; i++) {
            System.out.println("   " + (i+1) + ") " + cashiers[i].getName());
        }
    }


    public int checkAmount(String str) {
        if (checkIsNotNull(str) && checkHasSymbol(str) && Integer.parseInt(str) > 0){
            return Integer.parseInt(str);
        } else {
            System.out.print("Количество выбранного продукта: ");
            checkAmount(scanner.nextLine());
        }
        return 1;
    }

    public double checkDiscount(String str) {
        if (checkIsNotNull(str) && checkHasSymbol(str)){
            return Double.parseDouble(str);
        } else {
            System.out.print("Скидка на продукт: ");
            checkDiscount(scanner.nextLine());
        }
        return 0;
    }

    public void checkAnswer(String str) {
        if (str.equals("да") || str.equals("Да") || str.equals("ДА")) {
            setAnswer(true);
        } else if (str.equals("нет") || str.equals("Нет") || str.equals("НЕТ")) {
            setAnswer(false);
        } else {
            System.out.print("Продолжаем? (да или нет): ");
            checkAnswer(scanner.nextLine());
        }
    }

    private boolean checkIsNotNull(String string) {
        if (string.equals("") || string.charAt(0) == ' ') {
            return  false;
        } else {
            return true;
        }
    }

    private boolean checkHasSymbol(String string) {
        if (string.matches(".*[a-z].*") || string.matches(".*[а-я].*")) {
            return false;
        } else {
            return true;
        }
    }

    private void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

}
