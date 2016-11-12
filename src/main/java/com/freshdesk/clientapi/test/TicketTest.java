package com.freshdesk.clientapi.test;

import com.freshdesk.clientapi.domain.Agent;
import com.freshdesk.clientapi.domain.Answer;
import com.freshdesk.clientapi.repository.TicketRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.freshdesk.clientapi.domain.Ticket;
import com.freshdesk.clientapi.enums.PriorityType;
import com.freshdesk.clientapi.enums.StatusType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcus on 29/03/2016.
 */
public class TicketTest {
    public static void main(String[] args) {


        //region post Ticket
        /*
        Ticket t = postTicket();
        System.out.println("Ticket Created: #"+t.getDisplay_id());
        */
        //endregion post Ticket


        //region get Ticket
        //Ticket ticke = getTicket(t.getDisplay_id());
        /*
        Ticket ticke = getTicket(13l);
        System.out.println("Ticket found: #" + ticke.getDisplay_id());
        */
        //endregion get Ticket


        //region assign Agent
/*
        Agent a = new Agent();
        a.setId(14001027567l);
        Boolean flag = assignAgent(ticke, a);
        if(flag) System.out.println("Agent assigned");
        else System.out.println("Agent isn't assigned");
*/
        //endregion assign Agent


        //region add Notes
/*
        Answer answer = addNote(ticke);
        System.out.println("Note add: "+answer.getId());
*/
        //endregion add Notes


        //region put Ticket
/*
        ticke = putTicket(ticke);
        System.out.println("Ticket updated: #" + ticke.getDisplay_id());
*/
        //endregion put Ticket


        //region list Tickets
/*
        List<Ticket> tickets = new TicketRepository().findAll();
        tickets.forEach(l-> {
            //if(l.getRequester_id()==)
            System.out.println("List Ticket #"+l.getDisplay_id());
        });

        List<Ticket> l = new TicketRepository().findAll();
        l.isEmpty();

        boolean exit = false;
        int page = 1;
        List<Ticket> tickets = new ArrayList<>();
        while (!exit){
            List<Ticket> l = new TicketRepository().findAll(page);
            if(!l.isEmpty())
                l.forEach(t -> tickets.add(t));
            else exit = true;
            page++;
        }
*/
        //endregion list Tickets


        //region list Tickets by User Id
/*
        List<Ticket> tickets = getTicketsByUserId(14001063561l);
*/
        //endregion list Tickets by User Id


        //region list Tickets by Agent Id
        //List<Ticket> ticketsA = getTicketsByAgentId(14001031858l);
        //endregion list Tickets by User Email

        //region list Tickets by Agent Id
        List<Ticket> ticketsA = getTicketsByAgentIdNewAndMyOpen(14001031858l);
        //endregion list Tickets by User Email


        //region list Tickets by User Email
        List<Ticket> tickets = getTicketsByUserEmail("flavio@hotmail.com");
        //endregion list Tickets by User Email
    }

    private static List<Ticket> getTicketsByAgentIdNewAndMyOpen(long id) {
        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.findByAgentUserIdNewAndMyOpen(id);
    }

    //region methods implementeds
    private static List<Ticket> getTicketsByAgentId(long id) {
        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.findByAgentUserId(id);
    }

    private static List<Ticket> getTicketsByUserEmail(String email) {
        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.findByUserEmail(email);
    }

    private static List<Ticket> getTicketsByUserId(long id) {
        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.findByUserId(id);
    }

    private static boolean assignAgent(Ticket ticke, Agent agent) {
        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.assignAgent(ticke,agent);
    }

    private static Answer addNote(Ticket ticke) {
        Answer answer = new Answer();
        answer.setBody("Eu sou um cara ehhe");
        answer.setPrivat(false);
        answer.setUser_id(14000935624l);

        TicketRepository ticketRepository = new TicketRepository();
        return ticketRepository.addAnswer(ticke, answer);
    }

    private static Ticket putTicket(Ticket ticke) {
        ticke.setStatus(StatusType.Closed.getValue());
        ticke.setPriority(PriorityType.Urgent.getValue());
        TicketRepository ticketRepository = new TicketRepository();
        ticke = ticketRepository.save(ticke);
        return ticke;
    }

    private static Ticket getTicket(long id) {
        TicketRepository ticketRepository = new TicketRepository();
        Ticket ticket = ticketRepository.find(id);
        return ticket;
    }

    private static String getJson(){
        return "{\"helpdesk_ticket\":{\"cc_email\":{\"cc_emails\":[\"marcus.sa@hotmail.com\",\"dasdsa@hotmail.com\"],\"fwd_emails\":[],\"reply_cc\":[\"marcus.sa@hotmail.com\",\"dasdsa@hotmail.com\"],\"tkt_cc\":[\"marcus.sa@hotmail.com\",\"dasdsa@hotmail.com\"]},\"created_at\":\"2016-03-29T22:30:42-04:00\",\"deleted\":false,\"delta\":true,\"description\":\"Detalhes do ticket\",\"description_html\":\"\\u003Cdiv\\u003EDetalhes do ticket\\u003C/div\\u003E\",\"display_id\":3,\"due_by\":\"2016-04-01T17:00:00-04:00\",\"email_config_id\":null,\"frDueBy\":\"2016-03-30T17:00:00-04:00\",\"fr_escalated\":false,\"group_id\":null,\"id\":14000699668,\"isescalated\":false,\"notes\":[{\"note\":{\"body\":\"created_by: 14000935624\\ntime: 2016-03-29 22:30:42 -0400\",\"body_html\":\"\\u003Cdiv\\u003Ecreated_by: 14000935624\\u003Cbr\\u003Etime: 2016-03-29 22:30:42 -0400\\u003C/div\\u003E\",\"created_at\":\"2016-03-29T22:30:42-04:00\",\"deleted\":false,\"id\":14001074723,\"incoming\":false,\"private\":true,\"source\":4,\"updated_at\":\"2016-03-29T22:30:42-04:00\",\"user_id\":14001031858,\"attachments\":[],\"support_email\":null}}],\"owner_id\":null,\"priority\":1,\"requester_id\":14001031858,\"responder_id\":null,\"source\":2,\"spam\":false,\"status\":2,\"subject\":\"Titulo do ticket\",\"ticket_type\":null,\"to_email\":null,\"trained\":false,\"updated_at\":\"2016-03-29T22:30:42-04:00\",\"urgent\":false,\"status_name\":\"Abertos\",\"requester_status_name\":\"Em processamento\",\"priority_name\":\"Baixa\",\"source_name\":\"Portal\",\"requester_name\":\"Luciano\",\"responder_name\":\"No Agent\",\"to_emails\":null,\"product_id\":null,\"attachments\":[],\"custom_field\":{},\"tags\":[]}}";
    }

    private static Ticket postTicket() {
        Ticket t = new Ticket();
        t.setEmail("flavio@hotmail.com");
        t.setDescription("Conteudo da treta man");
        t.setPriority(1);
        t.setStatus(2);
        t.setSubject("Ticket test por luciano");
        t.addCc_email("marcusvinicius@hotmail.com");//.addCc_email("dasdsa@hotmail.com");
        t.setResponder_id(14001031858l);
        TicketRepository ticketRepository = new TicketRepository();
        Ticket ticket = ticketRepository.save(t);
        return ticket;
    }
    //endregion methods implementeds
}
