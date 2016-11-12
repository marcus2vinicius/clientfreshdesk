package com.freshdesk.clientapi.domain;

/**
 * Created by usuario on 30/03/16.
 */
public class Agent {
    public Object active_since;
    public Boolean available;
    public String created_at;
    public Long id;
    public Boolean occasional;
    public Integer points;
    public Integer scoreboard_level_id;
    public Object signature;
    public String signature_html;
    public Integer ticket_permission;
    public String updated_at;
    public User user;
    public Long user_id;

    public Object getActive_since() {
        return active_since;
    }

    public void setActive_since(Object active_since) {
        this.active_since = active_since;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOccasional() {
        return occasional;
    }

    public void setOccasional(Boolean occasional) {
        this.occasional = occasional;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getScoreboard_level_id() {
        return scoreboard_level_id;
    }

    public void setScoreboard_level_id(Integer scoreboard_level_id) {
        this.scoreboard_level_id = scoreboard_level_id;
    }

    public Object getSignature() {
        return signature;
    }

    public void setSignature(Object signature) {
        this.signature = signature;
    }

    public String getSignature_html() {
        return signature_html;
    }

    public void setSignature_html(String signature_html) {
        this.signature_html = signature_html;
    }

    public Integer getTicket_permission() {
        return ticket_permission;
    }

    public void setTicket_permission(Integer ticket_permission) {
        this.ticket_permission = ticket_permission;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
