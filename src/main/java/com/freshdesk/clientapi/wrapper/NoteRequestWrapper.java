package com.freshdesk.clientapi.wrapper;

import com.google.gson.annotations.SerializedName;
import com.freshdesk.clientapi.domain.Answer;

/**
 * Created by usuario on 30/03/16.
 */
public class NoteRequestWrapper {
    @SerializedName("helpdesk_note")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
