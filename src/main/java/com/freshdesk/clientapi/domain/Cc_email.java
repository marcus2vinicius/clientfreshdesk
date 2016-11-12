package com.freshdesk.clientapi.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcus on 29/03/2016.
 */
public class Cc_email {
    private List<String> cc_emails = new ArrayList<String>();
    private List<Object> fwd_emails = new ArrayList<Object>();
    private List<String> reply_cc = new ArrayList<String>();
    private List<String> tkt_cc = new ArrayList<String>();

    public List<String> getCc_emails() {
        return cc_emails;
    }

    public void setCc_emails(List<String> cc_emails) {
        this.cc_emails = cc_emails;
    }

    public List<Object> getFwd_emails() {
        return fwd_emails;
    }

    public void setFwd_emails(List<Object> fwd_emails) {
        this.fwd_emails = fwd_emails;
    }

    public List<String> getReply_cc() {
        return reply_cc;
    }

    public void setReply_cc(List<String> reply_cc) {
        this.reply_cc = reply_cc;
    }

    public List<String> getTkt_cc() {
        return tkt_cc;
    }

    public void setTkt_cc(List<String> tkt_cc) {
        this.tkt_cc = tkt_cc;
    }
}
