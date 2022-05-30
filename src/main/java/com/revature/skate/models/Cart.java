package com.revature.skate.models;

public class Cart {
    private String id;
    private int quantity;
    private double total;
    private String user_id;
    private String decks_id;
    private double fTotal;


    public Cart(String id, int quantity, double total, String user_id, String decks_id) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.user_id = user_id;
        this.decks_id = decks_id;

    }

    public Cart(double fTotal){
        this.fTotal = fTotal;
    }
    public Cart(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDecks_id() {
        return decks_id;
    }

    public void setDecks_id(String decks_id) {
        this.decks_id = decks_id;
    }

    public double getFTotal() {
        return fTotal;
    }

    public void setFTotal(double fTotal) {
        this.fTotal = fTotal;
    }

    @Override
    public String toString() {
        return "deck id= " + decks_id +
                ", quantity= " + quantity +
                ", subtotal= $" + total + "\n";
    }
}

