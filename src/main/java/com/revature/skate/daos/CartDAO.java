package com.revature.skate.daos;

import com.revature.skate.models.Cart;
import com.revature.skate.models.Decks;
import com.revature.skate.models.User;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CrudDAO<Cart> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Cart obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO carts (id, quantity, total, users_id, decks_id) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setInt(2, obj.getQuantity());
            ps.setDouble(3, obj.getTotal());
            ps.setString(4, obj.getUser_id());
            ps.setString(5, obj.getDecks_id());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while connecting to database");
        }

    }

    @Override
    public void update(Cart obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Cart getById(String id) {
        return null;
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> cart = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cart.add(new Cart(rs.getString("id"), rs.getInt("quantity"), rs.getDouble("total"), rs.getString("user_id"), rs.getString("decks_id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when tyring to retrieve data from the database.");
        }
        return cart;
    }

    public List<Cart> getCartByUserId(String user_id) {
        List<Cart> cart = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carts WHERE users_id = (?)");
            ps.setString(1, user_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cart.add(new Cart(rs.getString("id"), rs.getInt("quantity"), rs.getDouble("total"), rs.getString("users_id"), rs.getString("decks_id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when tyring to get data from to the database.");
        }

        return cart;
    }

    public List<Double> getTotalByUserId(String user_id) {
        List<Double> cartTotal = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(total) FROM carts WHERE users_id = (?)");
            ps.setString(1, user_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                cartTotal.add(rs.getDouble("sum"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when tyring to get data from to the database.");
        }

        return cartTotal;
    }
}
