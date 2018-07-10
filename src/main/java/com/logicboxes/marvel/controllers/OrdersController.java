package com.logicboxes.marvel.controllers;

import com.logicboxes.marvel.exceptions.OrderNotFoundException;
import com.logicboxes.marvel.models.Order;
import com.logicboxes.marvel.requests.AddOrderRequest;
import com.logicboxes.marvel.requests.RenewRequest;
import com.logicboxes.marvel.services.orders.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/orders")
public class OrdersController
{
    private OrderService orderService;

    public OrdersController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<?> getByID(@PathVariable long id) throws OrderNotFoundException
    {
        Order order = this.orderService.getOrderByID(id);
        return ResponseEntity.ok(order);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> addOrder(@RequestBody AddOrderRequest request)
    {
        Order createdOrder = this.orderService.addOrder(request.getUser_id(), request.getExpiry());
        return ResponseEntity.ok(createdOrder);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> deleteByID(@PathVariable long id) throws OrderNotFoundException
    {
        this.orderService.deleteOrderByID(id);
        return ResponseEntity.accepted().body("");
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public ResponseEntity<?> renewOrderByID(@PathVariable long id, @RequestBody RenewRequest request)
            throws OrderNotFoundException
    {
        Order order = this.orderService.renewOrderByID(id, request.getExpiry());
        return ResponseEntity.ok(order);
    }

    @RequestMapping(value = "/by-user/{user_id}", method = GET)
    public ResponseEntity<?> getAllByUserID(@PathVariable long user_id)
    {
        List<Order> orders = this.orderService.getOrdersByUserID(user_id);
        return ResponseEntity.ok(orders);
    }
}
