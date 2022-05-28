package com.revature.skate.daos;


import com.revature.skate.models.Decks;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeckDAO implements CrudDAO<Decks>{

    Connection con = DatabaseConnection.getCon();
 //   String path ="src/main/resources/database/user.txt";
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
        return null;
    }

    @Override
    public List<Decks> getAll() {
        return null;
    }
}
