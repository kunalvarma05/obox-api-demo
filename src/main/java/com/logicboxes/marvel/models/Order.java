package com.logicboxes.marvel.models;

import java.io.Serializable;

public class Order implements Serializable
{

    private long id;

    private long user_id;

    private long expiry;

    public Order()
    {
    }

    public Order(long id, long user_id, long expiry)
    {
        this.id = id;
        this.user_id = user_id;
        this.expiry = expiry;
    }

    public long getId()
    {
        return id;
    }

    public long getUser_id()
    {
        return user_id;
    }

    public long getExpiry()
    {
        return expiry;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setUser_id(long user_id)
    {
        this.user_id = user_id;
    }

    public void setExpiry(long expiry)
    {
        this.expiry = expiry;
    }
}
