package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LightCapabilities {
    private boolean certified;
    private Control control;
    private Streaming streaming;

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public Streaming getStreaming() {
        return streaming;
    }

    public void setStreaming(Streaming streaming) {
        this.streaming = streaming;
    }

    public class Control {
        @JsonProperty("mindimlevel")
        private int minDimLevel;
        @JsonProperty("maxlumen")
        private int maxLumen;
        @JsonProperty("ct")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private ColourTemperature colourTemperature;


        public int getMinDimLevel() {
            return minDimLevel;
        }

        public void setMinDimLevel(int minDimLevel) {
            this.minDimLevel = minDimLevel;
        }

        public int getMaxLumen() {
            return maxLumen;
        }

        public void setMaxLumen(int maxLumen) {
            this.maxLumen = maxLumen;
        }

        public ColourTemperature getColourTemperature() {
            return colourTemperature;
        }

        public void setColourTemperature(ColourTemperature colourTemperature) {
            this.colourTemperature = colourTemperature;
        }

        public class ColourTemperature {
            @JsonProperty("min")
            private int minimum;
            @JsonProperty("max")
            private int maximum;

            public int getMinimum() {
                return minimum;
            }

            public void setMinimum(int minimum) {
                this.minimum = minimum;
            }

            public int getMaximum() {
                return maximum;
            }

            public void setMaximum(int maximum) {
                this.maximum = maximum;
            }
        }
    }

    public class Streaming {
        private boolean renderer;
        private boolean proxy;

        public boolean isRenderer() {
            return renderer;
        }

        public void setRenderer(boolean renderer) {
            this.renderer = renderer;
        }

        public boolean isProxy() {
            return proxy;
        }

        public void setProxy(boolean proxy) {
            this.proxy = proxy;
        }
    }
}
