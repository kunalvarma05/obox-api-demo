package com.logicboxes.marvel.repositories.orders;

import com.logicboxes.marvel.exceptions.OrderNotFoundException;
import com.logicboxes.marvel.models.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository
{
    Order get(long id) throws OrderNotFoundException;

    List<Order> getAllByUserID(long id);

    List<Order> getAll();

    void delete(long id) throws OrderNotFoundException;

    Order renew(long id, long expiry) throws OrderNotFoundException;

    Order add(Order order);
}
