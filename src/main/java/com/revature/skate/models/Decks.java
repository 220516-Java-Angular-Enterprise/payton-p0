package com.revature.skate.models;

public class Decks {
    private String id;
    private String brand;
    private double size;
    private double price;

    public Decks() {

    }

    public Decks(String id, String brand, double size, double price){
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand: " + brand +
                "\nSize: " + size +
                "\nPrice: " + price;
    }
}
