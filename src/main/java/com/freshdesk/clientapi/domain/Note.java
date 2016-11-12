package com.freshdesk.clientapi.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marcus on 29/03/2016.
 */
public class Note {
    @SerializedName("note")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
