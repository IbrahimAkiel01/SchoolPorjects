package model;

public class Product implements RestaurantItems{
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return String.format("%s %s", name + ", ", price + "kr");
}
}
