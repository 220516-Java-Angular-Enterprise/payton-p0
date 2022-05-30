package com.revature.skate.services;

import com.revature.skate.daos.OrderDAO;
import com.revature.skate.models.Orders;

import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void register(Orders orders){
        orderDAO.save(orders);
    }

    public List<Orders> getAllHistory(String id){
        return orderDAO.getAllHistory(id);
    }
}
