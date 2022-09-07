package Lesson19.shop.enums;

public enum ProductCategory {
    DAIRYPRODUCT("Молочка"),
    FRUIT("Фрукты"),

    DESSERT("Десерты");

    private String categoryName;

    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
