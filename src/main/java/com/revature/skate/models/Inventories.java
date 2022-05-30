package com.revature.skate.models;

public class Inventories {
    private String id;
    private int quantity;
    private String decks_id;

    public Inventories(String id, int quantity, String decks_id) {
        this.id = id;
        this.quantity = quantity;
        this.decks_id = decks_id;
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

    public String getDecks_id() {
        return decks_id;
    }

    public void setDecks_id(String decks_id) {
        this.decks_id = decks_id;
    }

    @Override
    public String toString() {
        return "Inventories{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", decks_id='" + decks_id + '\'' +
                '}';
    }
}
