package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LightBulbConfig {
    private String archetype;
    private String function;
    private String direction;
    @JsonProperty("startup")
    private StartUp startUp;

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public StartUp getStartUp() {
        return startUp;
    }

    public void setStartUp(StartUp startUp) {
        this.startUp = startUp;
    }

    public class StartUp {
        private String mode;
        private boolean configured;

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public boolean isConfigured() {
            return configured;
        }

        public void setConfigured(boolean configured) {
            this.configured = configured;
        }
    }
}
