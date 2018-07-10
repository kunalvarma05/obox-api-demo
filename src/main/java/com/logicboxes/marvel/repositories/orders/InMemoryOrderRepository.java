package com.logicboxes.marvel.repositories.orders;

import com.logicboxes.marvel.exceptions.OrderNotFoundException;
import com.logicboxes.marvel.models.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InMemoryOrderRepository implements OrderRepository
{
    private static long NEW_ID = 9;

    private static Map<Long, Order> orders = new HashMap<>();

    static
    {
        orders.put(1L, new Order(1, 1, 1000));
        orders.put(2L, new Order(2, 2, 2000));
        orders.put(3L, new Order(3, 3, 3000));
        orders.put(4L, new Order(4, 4, 3500));
        orders.put(5L, new Order(5, 2, 1000));
        orders.put(6L, new Order(6, 1, 2000));
        orders.put(7L, new Order(7, 4, 3000));
        orders.put(8L, new Order(8, 3, 3500));
    }


    @Override
    public Order get(long id) throws OrderNotFoundException
    {
        Order order = orders.get(id);

        if (order == null)
        {
            throw new OrderNotFoundException(id);
        }

        return order;
    }

    @Override
    public List<Order> getAllByUserID(long id)
    {
        List<Order> orders = this.getAll();
        return orders.stream()
                .filter(o -> o.getUser_id() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getAll()
    {
        return new ArrayList(orders.values());
    }

    @Override
    public void delete(long id) throws OrderNotFoundException
    {
        Order order = orders.get(id);

        if (order == null)
        {
            throw new OrderNotFoundException(id);
        }

        orders.remove(id);
    }

    @Override
    public Order renew(long id, long expiry) throws OrderNotFoundException
    {
        Order order = orders.get(id);

        if (order == null)
        {
            throw new OrderNotFoundException(id);
        }

        order.setExpiry(order.getExpiry() + expiry);
        orders.put(id, order);
        return order;
    }

    @Override
    public Order add(long user_id, long expiry)
    {
        Order order = new Order(NEW_ID, user_id, expiry);
        orders.put(NEW_ID, order);
        ++NEW_ID;
        return order;
    }

}
