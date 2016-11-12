package com.freshdesk.clientapi.enums;

/**
 * Created by usuario on 30/03/16.
 */
public enum PriorityType {
    Low(1,"Low"), Medium(2,"Medium"), High(3,"High"), Urgent(4,"Urgent");

    private final int value;
    private final String descrip;

    PriorityType(int valueparam, String descripparam)
    {
        value = valueparam;
        descrip = descripparam;
    }

    public int getValue(){ return value; }
    public String getDescrip(){ return descrip; }
}
