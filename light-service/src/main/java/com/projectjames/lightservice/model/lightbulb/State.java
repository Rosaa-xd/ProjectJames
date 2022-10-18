package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class State {

    private boolean on;

    @JsonProperty("bri")
    private int brightness;

    private int hue;

    @JsonProperty("sat")
    private int saturation;

    private String effect;

    private float[] xy;

    private String alert;

    private String mode;

    private String reachable;

    @JsonProperty("ct")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int colourTemperature;

    @JsonProperty("colormode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String colourMode;
}
