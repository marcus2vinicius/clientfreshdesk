package com.freshdesk.clientapi.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Marcus on 30/03/2016.
 */
public class Answer {
    private String body;
    private String body_html;
    private Date created_at;
    private Boolean deleted;
    private Long id;
    private Boolean incoming;
    @SerializedName("private")
    private Boolean privat;
    private Integer source;
    private Date updated_at;
    private Long user_id;
    private Object support_email;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody_html() {
        return body_html;
    }

    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIncoming() {
        return incoming;
    }

    public void setIncoming(Boolean incoming) {
        this.incoming = incoming;
    }

    public Boolean getPrivat() {
        return privat;
    }

    public void setPrivat(Boolean privat) {
        this.privat = privat;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Object getSupport_email() {
        return support_email;
    }

    public void setSupport_email(Object support_email) {
        this.support_email = support_email;
    }
}
