package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

public class SwUpdate {
    private String state;
    @JsonProperty("lastinstall")
    private Date lastInstall;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getLastInstall() {
        return lastInstall;
    }

    public void setLastInstall(Date lastInstall) {
        this.lastInstall = lastInstall;
    }
}
