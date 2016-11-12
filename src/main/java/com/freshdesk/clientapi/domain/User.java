package com.freshdesk.clientapi.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marcus on 28/03/2016.
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String description;
    private String job_title;
    private String twitter_id;
    private String fb_profile_id;
    private String phone;
    private String mobile;
    private String language;
    private String time_zone;
    private Integer customer_id;
    private Boolean deleted;
    private Boolean helpdesk_agent;
    private Boolean active;
    private Integer external_id;
    private String avatar_attributes;
    private Object custom_field;
    //Response
    private Date created_at;
    private Date updated_at;
    private String company_id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getFb_profile_id() {
        return fb_profile_id;
    }

    public void setFb_profile_id(String fb_profile_id) {
        this.fb_profile_id = fb_profile_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getHelpdesk_agent() {
        return helpdesk_agent;
    }

    public void setHelpdesk_agent(Boolean helpdesk_agent) {
        this.helpdesk_agent = helpdesk_agent;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getExternal_id() {
        return external_id;
    }

    public void setExternal_id(Integer external_id) {
        this.external_id = external_id;
    }

    public String getAvatar_attributes() {
        return avatar_attributes;
    }

    public void setAvatar_attributes(String avatar_attributes) {
        this.avatar_attributes = avatar_attributes;
    }

    public Object getCustom_field() {
        return custom_field;
    }

    public void setCustom_field(Object custom_field) {
        this.custom_field = custom_field;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public boolean isPersisted(){
        if(id != null && id>0) return true;
        else return false;
    }
}
