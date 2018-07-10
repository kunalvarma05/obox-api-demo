package com.logicboxes.marvel.exceptions;

public class OrderNotFoundException extends Exception
{
    public OrderNotFoundException()
    {
        super("Order not found");
    }

    public OrderNotFoundException(String message)
    {
        super(message);
    }

    public OrderNotFoundException(long id)
    {
        super("The following order was not found: " + id);
    }
}
