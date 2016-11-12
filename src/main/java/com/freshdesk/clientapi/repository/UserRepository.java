package com.freshdesk.clientapi.repository;

import com.freshdesk.clientapi.domain.Agent;
import com.freshdesk.clientapi.wrapper.AgentResponseWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.freshdesk.clientapi.domain.User;
import com.freshdesk.clientapi.wrapper.UserResponseWrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcus on 29/03/2016.
 */
public class UserRepository {
    String path = "/contacts";

    public User save(User user){
        if(user.isPersisted())
            return update(user);
        else return insert(user);
    }

    private User update(User user) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk()
                .put(gson.toJson(new UserResponseWrapper(user)), user.getId(), path);
        return gson.fromJson(responseJson,UserResponseWrapper.class).getUser();
    }

    private User insert(User user) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().post(gson.toJson(new UserResponseWrapper(user)), path);
        return gson.fromJson(responseJson, UserResponseWrapper.class).getUser();
    }

    public User find(Long id){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().get(id.toString(), path);
        User user = gson.fromJson(responseJson,UserResponseWrapper.class).getUser();
        return user;
    }

    public List<User> findAll() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk().get(path);
        Type listType = new TypeToken<ArrayList<UserResponseWrapper>>(){}.getType();
        List<UserResponseWrapper> list = gson.fromJson(responseJson, listType);
        return list.stream().map(l->l.getUser()).collect(Collectors.toList());
    }

    public Agent makerAgent(User user){
        String path2 = "make_agent";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String responseJson = new ConnectionsFreshDesk()
                .put(null, path, user.getId(), path2, Agent.class);
        return gson.fromJson(responseJson,AgentResponseWrapper.class).getAgent();
    }
}
