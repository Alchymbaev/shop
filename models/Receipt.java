package Lesson19.shop.models;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Receipt {
    private double totalSum;
    private double totalDiscount;

    public Receipt(double totalSum, double totalDiscount) {
        this.totalSum = totalSum;
        this.totalDiscount = totalDiscount;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double total(){
        return (totalSum - totalDiscount);
    }

    @Override
    public String toString() {
        return "Общая сумма продуктов: " + getTotalSum() +
                "\nОбщая сумма скидки: " + getTotalDiscount() +
                "\nИтого к оплате: " + total();
    }
}
