package com.logicboxes.marvel.requests;

public class AddOrderRequest extends BaseRequest
{
    private long user_id;

    private long expiry;

    public AddOrderRequest()
    {
    }

    public AddOrderRequest(long user_id, long expiry)
    {
        this.user_id = user_id;
        this.expiry = expiry;
    }

    public long getUser_id()
    {
        return user_id;
    }

    public void setUser_id(long user_id)
    {
        this.user_id = user_id;
    }

    public long getExpiry()
    {
        return expiry;
    }

    public void setExpiry(long expiry)
    {
        this.expiry = expiry;
    }
}
