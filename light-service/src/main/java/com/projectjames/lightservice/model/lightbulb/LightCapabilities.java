package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class LightCapabilities {

    private boolean certified;

    private Control control;

    private Streaming streaming;

    @Getter @Setter
    public class Control {

        @JsonProperty("mindimlevel")
        private int minDimLevel;

        @JsonProperty("maxlumen")
        private int maxLumen;

        @JsonProperty("colorgamuttype")
        private String colorGamutType;

        @JsonProperty("colorgamut")
        private List<List<Double>> colorGamut;

        @JsonProperty("ct")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private ColourTemperature colourTemperature;

        @Getter @Setter
        public class ColourTemperature {

            @JsonProperty("min")
            private int minimum;

            @JsonProperty("max")
            private int maximum;
        }
    }

    @Getter @Setter
    public class Streaming {

        private boolean renderer;

        private boolean proxy;
    }
}
