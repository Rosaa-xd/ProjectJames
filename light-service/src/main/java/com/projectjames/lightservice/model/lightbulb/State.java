package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class State {
    private boolean on;
    @JsonProperty("bri")
    private int brightness;
    private String alert;
    private String mode;
    private String reachable;
    @JsonProperty("ct")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String colourTemperature;
    @JsonProperty("colormode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String colourMode;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReachable() {
        return reachable;
    }

    public void setReachable(String reachable) {
        this.reachable = reachable;
    }

    public String getColourTemperature() {
        return colourTemperature;
    }

    public void setColourTemperature(String colourTemperature) {
        this.colourTemperature = colourTemperature;
    }

    public String getColourMode() {
        return colourMode;
    }

    public void setColourMode(String colorMode) {
        this.colourMode = colorMode;
    }
}
