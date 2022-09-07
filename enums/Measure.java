package Lesson19.shop.enums;

public enum Measure {
    KILOGRAMM("кг."),
    LITER("литр"),
    THING("шт.");

    private String measureName;

    Measure(String measureName) {
        this.measureName = measureName;
    }

    public String getMeasureName() {
        return measureName;
    }
}
