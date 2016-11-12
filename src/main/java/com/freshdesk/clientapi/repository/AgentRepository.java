package com.freshdesk.clientapi.repository;

import com.freshdesk.clientapi.wrapper.AgentResponseWrapper;
import com.freshdesk.clientapi.domain.Agent;
import com.freshdesk.clientapi.domain.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcus on 29/03/2016.
 */
public class AgentRepository {
    String path = "/agents";

    public Agent save(User user){
        if(user.isPersisted())
            return insert(user);
        else return null;
    }

    private Agent insert(User user) {
        UserRepository userRepository = new UserRepository();
        Agent agent = userRepository.makerAgent(user);
        return agent;
    }

    public Agent find(Long id){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().get(id.toString(), path);
        Agent agent = gson.fromJson(responseJson, AgentResponseWrapper.class).getAgent();
        return agent;
    }

    public List<Agent> findAll() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().get(path);
        Type listType = new TypeToken<ArrayList<AgentResponseWrapper>>(){}.getType();
        List<AgentResponseWrapper> list = gson.fromJson(responseJson, listType);
        return list.stream().map(l->l.getAgent()).collect(Collectors.toList());
    }
}
