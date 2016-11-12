package com.freshdesk.clientapi.wrapper;

import com.freshdesk.clientapi.domain.Agent;
import com.google.gson.annotations.SerializedName;

/**
 * Created by usuario on 30/03/16.
 */
public class AgentResponseWrapper {
    @SerializedName("agent")
    private Agent agent;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
