package com.freshdesk.clientapi.repository;

import com.freshdesk.clientapi.domain.Agent;
import com.freshdesk.clientapi.domain.Note;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.freshdesk.clientapi.domain.Answer;
import com.freshdesk.clientapi.domain.Ticket;
import com.freshdesk.clientapi.wrapper.NoteRequestWrapper;
import com.freshdesk.clientapi.wrapper.TicketResponseWrapper;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marcus on 29/03/2016.
 */
public class TicketRepository {
    String path = "/helpdesk/tickets";

    public Ticket save(Ticket ticket){
        if(ticket.isPersisted())
            return update(ticket);
        else return insert(ticket);
    }

    private Ticket update(Ticket ticket) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        TicketResponseWrapper ticketResponseWrapper = new TicketResponseWrapper();
        ticketResponseWrapper.setTicket(ticket);

        JsonObject attributes = new JsonObject();
        attributes.addProperty("priority",ticket.getPriority());
        attributes.addProperty("status",ticket.getStatus());
        JsonObject parent = new JsonObject();
        parent.add("helpdesk_ticket", attributes);

        String responseJson = new ConnectionsFreshDesk()
                .put(gson.toJson(parent), ticket.getDisplay_id(), path);
        return gson.fromJson(responseJson, Ticket.class);
    }

    private Ticket insert(Ticket ticket) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        TicketResponseWrapper ticketResponseWrapper = new TicketResponseWrapper();
        ticketResponseWrapper.setTicket(ticket);

        if(ticket.getCc_email() != null
                && ticket.getCc_email().getCc_emails() != null
                && !ticket.getCc_email().getCc_emails().isEmpty())
            ticketResponseWrapper.setCc_emails(ticket.getCc_email().getCc_emails());

        String responseJson = new ConnectionsFreshDesk().post(gson.toJson(ticketResponseWrapper), path);
        return gson.fromJson(responseJson, TicketResponseWrapper.class).getTicket();
    }

    public Ticket find(Long id){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().get(id.toString(), path);
        Ticket ticket = gson.fromJson(responseJson,TicketResponseWrapper.class).getTicket();
        return ticket;
    }

    public List<Ticket> findAll() {
        boolean exit = false;
        int page = 1;
        List<Ticket> tickets = new ArrayList<>();
        while (!exit){
            List<Ticket> l = findAll(page);
            if(!l.isEmpty())
                l.forEach(t -> tickets.add(t));
            else exit = true;
            page++;
        }
        return tickets;
    }

    public List<Ticket> findAll(Integer page) {
        String pathFull = "/filter/all_tickets";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("format", "json");
        ConnectionsFreshDesk conn = new ConnectionsFreshDesk();
        String responseJson = conn.get(path+pathFull, map);
        Type listType = new TypeToken<ArrayList<Ticket>>(){}.getType();
        List<Ticket> list = gson.fromJson(responseJson, listType);
        conn = null;
        listType = null;
        responseJson = null;
        map = null;
        return list;
    }

    public List<Ticket> findAllNewAndMyOpen() {
        boolean exit = false;
        int page = 1;
        List<Ticket> tickets = new ArrayList<>();
        while (!exit){
            List<Ticket> l = findAllNewAndMyOpen(page);
            if(!l.isEmpty())
                l.forEach(t -> tickets.add(t));
            else exit = true;
            page++;
        }
        return tickets;
    }

    public List<Ticket> findAllNewAndMyOpen(Integer page) {
            String pathFull = "/filter/new_and_my_open";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("format", "json");
        ConnectionsFreshDesk conn = new ConnectionsFreshDesk();
        String responseJson = conn.get(path+pathFull, map);
        Type listType = new TypeToken<ArrayList<Ticket>>(){}.getType();
        List<Ticket> list = gson.fromJson(responseJson, listType);
        conn = null;
        listType = null;
        responseJson = null;
        map = null;
        return list;
    }

    public Answer addAnswer(Ticket ticket, Answer answer){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String path2 = "/conversations/note";
        NoteRequestWrapper noteRequestWrapper = new NoteRequestWrapper();
        noteRequestWrapper.setAnswer(answer);
        String responseJson = new ConnectionsFreshDesk().post(gson.toJson(noteRequestWrapper), path, ticket.getDisplay_id(), path2);
        Answer a = gson.fromJson(responseJson, Note.class).getAnswer();
        return a;
    }

    public boolean assignAgent(Ticket ticket, Agent agent){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String path2 = "assign";
        String responseJson =
                new ConnectionsFreshDesk()
                        .put(null,
                                path, ticket.getDisplay_id(),
                                path2, Ticket.class, "responder_id", agent.getId().toString());
        return responseJson != null && !responseJson.isEmpty();
    }

    public List<Ticket> findByUserId(Long id){
        boolean exit = false;
        int page = 1;
        List<Ticket> tickets = new ArrayList<>();
        while (!exit){
            List<Ticket> l = findByUserId(id, page);
            if(!l.isEmpty())
                l.forEach(t -> tickets.add(t));
            else exit = true;
            page++;
        }
        return tickets;
    }

    public List<Ticket> findByAgentUserIdNewAndMyOpen(Long id){
        return findAllNewAndMyOpen().stream().filter(l -> l.getResponder_id() != null && l.getResponder_id().equals(id)).collect(Collectors.toList());
    }

    public List<Ticket> findByAgentUserId(Long id){
        return findAll().stream().filter(l -> l.getResponder_id() != null && l.getResponder_id().equals(id)).collect(Collectors.toList());
    }

    public List<Ticket> findByUserId(Long id, Integer page){
        String pathFull = path+"/filter/requester";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Map map = new HashMap<>();
        map.put("page",page);
        map.put("format","json");
        String responseJson = new ConnectionsFreshDesk().get(id.toString(), pathFull, map);
        Type listType = new TypeToken<ArrayList<Ticket>>(){}.getType();
        List<Ticket> tickets = gson.fromJson(responseJson, listType);
        return tickets;
    }

    public List<Ticket> findByUserEmail(String email){
        boolean exit = false;
        int page = 1;
        List<Ticket> tickets = new ArrayList<>();
        while (!exit){
            List<Ticket> l = findByUserEmail(email, page);
            if(!l.isEmpty())
                l.forEach(t -> tickets.add(t));
            else exit = true;
            page++;
        }
        return tickets;
    }

    public List<Ticket> findByUserEmail(String email, Integer page){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Map<String,Object> map = new HashMap<>();
        map.put("email",email);
        map.put("filter_name","all_tickets");
        map.put("page",page);
        //map.put("format","json");
        String responseJson = new ConnectionsFreshDesk().get(path, map);
        Type listType = new TypeToken<ArrayList<Ticket>>(){}.getType();
        List<Ticket> tickets = gson.fromJson(responseJson, listType);
        return tickets;
    }
}
