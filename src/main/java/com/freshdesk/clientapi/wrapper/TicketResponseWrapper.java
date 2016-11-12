package com.freshdesk.clientapi.wrapper;

import com.google.gson.annotations.SerializedName;
import com.freshdesk.clientapi.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 30/03/16.
 */
public class TicketResponseWrapper {
    @SerializedName("helpdesk_ticket")
    private Ticket ticket;
    @SerializedName("cc_emails")
    private List<String> cc_emails = new ArrayList();

    public Ticket getTicket() {
        return ticket;
    }

    public TicketResponseWrapper addCcEmail(String email){
        cc_emails.add(email);
        return this;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<String> getCc_emails() {
        return cc_emails;
    }

    public void setCc_emails(List<String> cc_emails) {
        this.cc_emails = cc_emails;
    }
}
