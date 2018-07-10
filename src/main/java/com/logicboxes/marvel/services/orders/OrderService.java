package com.logicboxes.marvel.services.orders;

import com.logicboxes.marvel.exceptions.OrderNotFoundException;
import com.logicboxes.marvel.models.Order;
import com.logicboxes.marvel.repositories.orders.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Order getOrderByID(long id) throws OrderNotFoundException
    {
        return this.orderRepository.get(id);
    }

    public List<Order> getOrdersByUserID(long user_id)
    {
        return this.orderRepository.getAllByUserID(user_id);
    }

    public void deleteOrderByID(long id) throws OrderNotFoundException
    {
        this.orderRepository.delete(id);
    }

    public Order renewOrderByID(long id, long expiry) throws OrderNotFoundException
    {
        return this.orderRepository.renew(id, expiry);
    }

    public Order addOrder(long user_id, long expiry)
    {
        return this.orderRepository.add(user_id, expiry);
    }
}
