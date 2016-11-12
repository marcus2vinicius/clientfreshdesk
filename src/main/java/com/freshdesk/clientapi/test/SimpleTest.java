package com.freshdesk.clientapi.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.freshdesk.clientapi.domain.Ticket;
import com.freshdesk.clientapi.domain.User;
import com.freshdesk.clientapi.wrapper.UserResponseWrapper;

/**
 * Created by Marcus on 29/03/2016.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.setDeleted(false);
        ticket.setDisplay_id(11l);
        ticket.setSubject("Titulo do ticket");
        ticket.setStatus_name("Abertos");
        ticket.setRequester_status_name("Em processamento");
        ticket.setPriority_name("Baixa");
        ticket.setSource_name("Portal");
        ticket.setRequester_name("user4090796509455514636");
        ticket.setResponder_name("Luciano");
        ticket.setTo_emails(null);
        ticket.setProduct_id(null);
        String s = new Gson().toJson(ticket);

        //createTicketManually();
        //testUser();
    }

    private static void createTicketManually() {
        JsonObject obj1 = new JsonObject();
        Ticket t = new Ticket();
        t.setStatus(4);
        t.setPriority(1);
        System.out.println(t.getPriority().getClass().getName());
        obj1.addProperty("priority", t.getPriority());
        obj1.addProperty("status", t.getStatus());

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("helpdesk_ticket", obj1);

        System.out.println(new Gson().toJson(jsonObject));

    }

    private static void testUser() {
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        UserResponseWrapper reponse = gson.fromJson(userString(),UserResponseWrapper.class);

        User u = new User();
        u.setEmail("adassmdasdasarfsdfcusdas.adsasvisdasnicius@facape.br");
        u.setPhone("1234567");
        u.setMobile("1234567");
        u.setName("marcusdsaddasda");
        String json = new Gson().toJson(new UserResponseWrapper(u));
        UserResponseWrapper response = new Gson().fromJson(json,UserResponseWrapper.class);
        User user = response.getUser();

    }

    private static String userString(){
        return "{\"user\":{\"active\":false,\"address\":null,\"created_at\":\"2016-03-29T12:28:42-04:00\",\"customer_id\":null,\"deleted\":false,\"description\":null,\"email\":\"viniscsius.marcssusAla@facape.br\",\"external_id\":null,\"fb_profile_id\":null,\"helpdesk_agent\":false,\"id\":14000992212,\"job_title\":null,\"language\":\"pt-BR\",\"mobile\":\"1234567\",\"name\":\"marcusdsaddasdadsa\",\"phone\":\"1234567\",\"time_zone\":\"Eastern Time (US \\u0026 Canada)\",\"twitter_id\":null,\"updated_at\":\"2016-03-29T12:28:42-04:00\",\"company_id\":null,\"custom_field\":{}}}";
    }
}
