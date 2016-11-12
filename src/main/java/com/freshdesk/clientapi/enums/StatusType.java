package com.freshdesk.clientapi.enums;

/**
 * Created by usuario on 30/03/16.
 */
public enum StatusType {
    Open(2,"Open"), Pending(3,"Pending"), Resolved(4,"Resolved"), Closed(5,"Closed");

    private final int value;
    private final String descrip;

    StatusType(int valueparam, String descripparam)
    {
        value = valueparam;
        descrip = descripparam;
    }

    public int getValue(){ return value; }
    public String getDescrip(){ return descrip; }
}
