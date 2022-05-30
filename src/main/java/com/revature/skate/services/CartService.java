package com.revature.skate.services;

import com.revature.skate.daos.CartDAO;
import com.revature.skate.models.Cart;
import com.revature.skate.models.Decks;

import java.util.List;

public class CartService {
    private final CartDAO cartDAO;


    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }
    public void register(Cart cart) {
        cartDAO.save(cart);
    }

    public List<Cart> getAllCart(){
        return cartDAO.getAll();
    }

    public List<Cart> getCartByUserId(String id){
        return cartDAO.getCartByUserId(id);
    }

    public List<Double> getTotalByUserId(String id){
        return cartDAO.getTotalByUserId(id);
    }
}
