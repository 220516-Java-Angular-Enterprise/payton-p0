package com.revature.skate.daos;

import com.revature.skate.models.Decks;
import com.revature.skate.models.Orders;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements CrudDAO<Orders>{
    Connection con = DatabaseConnection.getCon();
    @Override
    public void save(Orders obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders (id, total, date, users_id, decks_id) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setDouble(2, obj.getTotal());
            ps.setString(3, obj.getDate());
            ps.setString(4, obj.getUser_id());
            ps.setString(5, obj.getDecks_id());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while connecting to database");
        }

    }

    @Override
    public void update(Orders obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Orders getById(String id) {
        return null;
    }


    @Override
    public List<Orders> getAll() {
        return null;
    }

    public List<Orders> getAllHistory(String users_id) {
        List<Orders> orders = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE users_id = (?)");
            ps.setString(1, users_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                orders.add(new Orders(rs.getString("id"), rs.getString("date"), rs.getDouble("total"), rs.getString("users_id"), rs.getString("decks_id")));
            }
        }catch(SQLException e) {
            throw new RuntimeException("An error occurred when tyring to retrieve data from the database.");
        }
        return orders;
    }
}
