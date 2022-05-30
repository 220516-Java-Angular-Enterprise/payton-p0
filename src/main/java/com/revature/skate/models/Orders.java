package com.revature.skate.models;

import java.util.Date;

public class Orders {
    private String id;
    private String date;
    private double total;
    private String user_id;
    private String decks_id;

    public Orders(String id, String date,double total, String userId, String deckId) {
        this.id = id;
        this.date = date;
        this. total = total;
        this.user_id = user_id;
        this.decks_id = decks_id;
    }
    public Orders(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String userId) {
        this.user_id = userId;
    }

    public String getDecks_id() {
        return decks_id;
    }

    public void setDecks_id(String deckId) {
        this.decks_id = deckId;
    }

    @Override
    public String toString() {
        return "\nDate='" + date +
                "\nTotal=" + total +
                "\n--------------------";
    }
}
