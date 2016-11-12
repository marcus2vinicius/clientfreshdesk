package com.freshdesk.clientapi.test;

import com.freshdesk.clientapi.domain.Agent;
import com.freshdesk.clientapi.domain.Ticket;
import com.freshdesk.clientapi.domain.User;
import com.freshdesk.clientapi.repository.AgentRepository;
import com.freshdesk.clientapi.repository.TicketRepository;
import com.freshdesk.clientapi.repository.UserRepository;

import java.util.List;

/**
 * Created by usuario on 30/03/16.
 */
public class AgentTest {

    public static void main(String[] args) {

        //region Make Agent
        /*
        User u = new UserRepository().find(14001030795l);
        System.out.println("User found :"+u.getName());
        AgentRepository AgentRepository = new AgentRepository();//Tranform user to agent
        Agent a = AgentRepository.save(u);
        System.out.println("Make Agent from User: "+a.getUser().getName());
        */
        //endregion Make Agent

        //region get one agent
        /*
        Agent agent = getAgent(14000120181l);
        System.out.println("Agent found: "+agent.getUser().getName());
        */
        //endregion get one agent
        /*
        TicketRepository ticketRepository = new TicketRepository();
        Object o = ticketRepository.findByUserId(14001063561l,2);
        */
        //region get all
        List<Agent> agents = getAgents();
        agents.forEach(ag-> System.out.println("List Agents: "+ag.getUser().getName()+" - "+ag.getId()+" - "+ag.getUser().getId()));
        //endregion get all



    }

    private static Agent getAgent(long id) {
        AgentRepository agentRepository = new AgentRepository();
        return agentRepository.find(id);
    }

    public static List<Agent> getAgents() {
        AgentRepository agentRepository = new AgentRepository();
        return agentRepository.findAll();
    }
}
