package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LightBulbConfig {

    private String archetype;

    private String function;

    private String direction;

    @JsonProperty("startup")
    private StartUp startUp;

    @Getter @Setter
    public class StartUp {
        private String mode;
        private boolean configured;
    }
}
