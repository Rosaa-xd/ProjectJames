package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LightBulb {
    private int id;

    private State state;

    @JsonProperty("swupdate")
    private SwUpdate swUpdate;

    private String type;

    private String name;

    @JsonProperty("modelid")
    private String modelId;

    @JsonProperty("manufacturername")
    private String manufacturerName;

    @JsonProperty("productname")
    private String productName;

    private LightCapabilities capabilities;

    private LightBulbConfig config;

    @JsonProperty("uniqueid")
    private String uniqueId;

    @JsonProperty("swversion")
    private String swVersion;

    @JsonProperty("swconfigid")
    private String swConfigId;

    @JsonProperty("productid")
    private String productId;
}
