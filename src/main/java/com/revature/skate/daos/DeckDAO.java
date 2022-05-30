package com.revature.skate.daos;


import com.revature.skate.models.Decks;
import com.revature.skate.models.User;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeckDAO implements CrudDAO<Decks>{

    Connection con = DatabaseConnection.getCon();
    @Override
    public void save(Decks obj) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO decks (id, brand, size, price) VALUES(?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getBrand());
            ps.setDouble(3, obj.getSize());
            ps.setDouble(4, obj.getPrice());
            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("An error occurred while connecting to database");
        }
    }

    @Override
    public void update(Decks obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Decks getById(String id) {
        Decks decks = new Decks();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM decks WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                decks.setId(rs.getString("id"));
                decks.setBrand(rs.getString("brand"));
                decks.setSize(rs.getDouble("size"));
                decks.setPrice(rs.getDouble("price"));
            }
        }catch(SQLException e) {
            throw new RuntimeException("An error occurred while trying to retrieve data from database");
        }
        return decks;
    }

    @Override
    public List<Decks> getAll() {
        List<Decks> decks = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM decks");
                    ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                decks.add(new Decks(rs.getString("id"), rs.getString("brand"), rs.getDouble("size"), rs.getDouble("price")));
            }
        }catch(SQLException e) {
            throw new RuntimeException("An error occurred when tyring to retrieve data from the database.");
        }
        return decks;
    }
}
