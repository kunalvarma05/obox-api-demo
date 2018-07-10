package com.logicboxes.marvel.requests;

public class RenewRequest extends BaseRequest
{
    private long expiry;

    public RenewRequest()
    {
    }

    public RenewRequest(long expiry)
    {
        this.expiry = expiry;
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
