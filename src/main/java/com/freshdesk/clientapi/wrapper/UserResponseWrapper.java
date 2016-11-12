package com.freshdesk.clientapi.wrapper;

import com.google.gson.annotations.SerializedName;
import com.freshdesk.clientapi.domain.User;

/**
 * Created by usuario on 29/03/16.
 */
public class UserResponseWrapper {
    @SerializedName("user")
    private User user;

    public UserResponseWrapper(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
