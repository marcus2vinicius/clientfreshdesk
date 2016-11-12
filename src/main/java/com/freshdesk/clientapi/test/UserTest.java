package com.freshdesk.clientapi.test;

import com.freshdesk.clientapi.domain.User;
import com.freshdesk.clientapi.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Marcus on 29/03/2016.
 */
public class UserTest {
    public static void main(String[] args) {

        //region post User
/*
        User u = postUser();
        System.out.println("\nUser Inserted: "+u.getName()+" - "+u.getId());
*/
        //endregion post User

        //region get User
/*
        u = getUser(u.getId());
        System.out.println("\nUser Find: " + u.getName());
*/
        //endregion get User

        //region put User
/*
        putUser(u);
        System.out.println("\nUser Update: " + u.getName());
*/
        //endregion put User

        //region get all Users

        List<User> users = getUsers();
        users.forEach(l-> System.out.println("User List "+l.getName()+" - "+l.getId()+"\n") );

        //endregion get all Users
    }

    //region methods
    private static void putUser(User u) {
        u.setName("User updateDoZero: "+new Date());
        UserRepository userRepository = new UserRepository();
        userRepository.save(u);
    }

    private static User getUser(long id) {
        UserRepository userRepository = new UserRepository();
        return userRepository.find(id);
    }

    private static User postUser() {
        Long identification = new Random().nextLong();
        UserRepository userRepository = new UserRepository();
        User u = new User();
        u.setEmail("user"+ identification+"@facape.br");
        u.setPhone("1234567");
        u.setMobile("1234567");
        u.setName("user"+identification);
        u = userRepository.save(u);
        return u;
    }

    public static List<User> getUsers() {
        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
    }
    //endregion methods

}
