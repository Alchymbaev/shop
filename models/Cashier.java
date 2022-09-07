package Lesson19.shop.models;

public class Cashier {
    private String name;
    private String login;

    public Cashier(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Кассир: " + getName() + ", логин: " + getLogin() + "\n";
    }
}
