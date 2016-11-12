package com.freshdesk.clientapi.domain;

import java.util.List;

/**
 * Created by Marcus on 29/03/2016.
 */
public class Ticket {
    //@Expose(serialize = false)
    private Cc_email cc_email;
    ////@Expose(serialize = false)
    private String created_at;
    ////@Expose(serialize = false)
    private Boolean deleted;
    //@Expose(serialize = false)
    private Boolean delta;
    private String description;
    //@Expose(serialize = false)
    private String description_html;
    //@Expose(serialize = false)
    private Long display_id;
    //@Expose(serialize = false)
    private String due_by;
    //@Expose(serialize = false)
    private Object email_config_id;
    //@Expose(serialize = false)
    private String frDueBy;
    //@Expose(serialize = false)
    private Boolean fr_escalated;
    //@Expose(serialize = false)
    private Object group_id;
    //@Expose(serialize = false)
    private Long id;
    //@Expose(serialize = false)
    private Boolean isescalated;
    //@Expose(serialize = false)
    private List<Note> notes;
    //@Expose(serialize = false)
    private Object owner_id;
    private Integer priority;
    //@Expose(serialize = false)
    private Long requester_id;
    //@Expose(serialize = false)
    private Long responder_id;
    //@Expose(serialize = false)
    private Long source;
    //@Expose(serialize = false)
    private Boolean spam;
    private Integer status;
    private String subject;
    //@Expose(serialize = false)
    private Object ticket_type;
    //@Expose(serialize = false)
    private Object to_email;
    //@Expose(serialize = false)
    private Boolean trained;
    //@Expose(serialize = false)
    private String updated_at;
    //@Expose(serialize = false)
    private Boolean urgent;
    //@Expose(serialize = false)
    private String status_name;
    //@Expose(serialize = false)
    private String requester_status_name;
    //@Expose(serialize = false)
    private String priority_name;
    //@Expose(serialize = false)
    private String source_name;
    //@Expose(serialize = false)
    private String requester_name;
    //@Expose(serialize = false)
    private String responder_name;
    //@Expose(serialize = false)
    private Object to_emails;
    //@Expose(serialize = false)
    private Object product_id;
    //@Expose(serialize = false)
    private List<Object> attachments;
    //@Expose(serialize = false)
    private List<Object> tags;
    private String email;

    public Ticket addCc_email(String email){
        if(cc_email==null) cc_email = new Cc_email();
        cc_email.getCc_emails().add(email);
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Object owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getRequester_id() {
        return requester_id;
    }

    public void setRequester_id(Long requester_id) {
        this.requester_id = requester_id;
    }

    public Long getResponder_id() {
        return responder_id;
    }

    public void setResponder_id(Long responder_id) {
        this.responder_id = responder_id;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(Object ticket_type) {
        this.ticket_type = ticket_type;
    }

    public Object getTo_email() {
        return to_email;
    }

    public void setTo_email(Object to_email) {
        this.to_email = to_email;
    }

    public Boolean getTrained() {
        return trained;
    }

    public void setTrained(Boolean trained) {
        this.trained = trained;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getRequester_status_name() {
        return requester_status_name;
    }

    public void setRequester_status_name(String requester_status_name) {
        this.requester_status_name = requester_status_name;
    }

    public String getPriority_name() {
        return priority_name;
    }

    public void setPriority_name(String priority_name) {
        this.priority_name = priority_name;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getRequester_name() {
        return requester_name;
    }

    public void setRequester_name(String requester_name) {
        this.requester_name = requester_name;
    }

    public String getResponder_name() {
        return responder_name;
    }

    public void setResponder_name(String responder_name) {
        this.responder_name = responder_name;
    }

    public Object getTo_emails() {
        return to_emails;
    }

    public void setTo_emails(Object to_emails) {
        this.to_emails = to_emails;
    }

    public Object getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Object product_id) {
        this.product_id = product_id;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Cc_email getCc_email() {
        return cc_email;
    }

    public void setCc_email(Cc_email cc_email) {
        this.cc_email = cc_email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDelta() {
        return delta;
    }

    public void setDelta(Boolean delta) {
        this.delta = delta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_html() {
        return description_html;
    }

    public void setDescription_html(String description_html) {
        this.description_html = description_html;
    }

    public Long getDisplay_id() {
        return display_id;
    }

    public void setDisplay_id(Long display_id) {
        this.display_id = display_id;
    }

    public String getDue_by() {
        return due_by;
    }

    public void setDue_by(String due_by) {
        this.due_by = due_by;
    }

    public Object getEmail_config_id() {
        return email_config_id;
    }

    public void setEmail_config_id(Object email_config_id) {
        this.email_config_id = email_config_id;
    }

    public String getFrDueBy() {
        return frDueBy;
    }

    public void setFrDueBy(String frDueBy) {
        this.frDueBy = frDueBy;
    }

    public Boolean getFr_escalated() {
        return fr_escalated;
    }

    public void setFr_escalated(Boolean fr_escalated) {
        this.fr_escalated = fr_escalated;
    }

    public Object getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Object group_id) {
        this.group_id = group_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsescalated() {
        return isescalated;
    }

    public void setIsescalated(Boolean isescalated) {
        this.isescalated = isescalated;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public boolean isPersisted(){
        if(id != null && id>0) return true;
        else return false;
    }

}
