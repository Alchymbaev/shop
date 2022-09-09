package Lesson19.shop.models;

import java.text.DecimalFormat;

public class Receipt {
    private double totalSum;
    private double totalDiscount;

    private static final DecimalFormat df = new DecimalFormat("0.00");

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

    public String total(){
        return df.format(totalSum - totalDiscount);
    }

    @Override
    public String toString() {
        return "Общая сумма продуктов: " + getTotalSum() +
                "\nОбщая сумма скидки: " + getTotalDiscount() +
                "\nИтого к оплате: " + total();
    }
}
