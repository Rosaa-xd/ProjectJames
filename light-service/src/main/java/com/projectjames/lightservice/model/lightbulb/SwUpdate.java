package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class SwUpdate {

    private String state;

    @JsonProperty("lastinstall")
    private Date lastInstall;
}
