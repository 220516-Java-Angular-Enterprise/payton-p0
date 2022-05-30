package com.revature.skate.daos;

import com.revature.skate.models.Inventories;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class InventoriesDAO implements CrudDAO<Inventories>{
    Connection con = DatabaseConnection.getCon();
    @Override
    public void save(Inventories obj) {

    }

    @Override
    public void update(Inventories obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Inventories getById(String id) {
        return null;
    }

    @Override
    public List<Inventories> getAll() {
        return null;
    }
}
