package com.projectjames.lightservice.model.lightbulb;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public SwUpdate getSwUpdate() {
        return swUpdate;
    }

    public void setSwUpdate(SwUpdate swUpdate) {
        this.swUpdate = swUpdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LightCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(LightCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public LightBulbConfig getConfig() {
        return config;
    }

    public void setConfig(LightBulbConfig config) {
        this.config = config;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    public String getSwConfigId() {
        return swConfigId;
    }

    public void setSwConfigId(String swConfigId) {
        this.swConfigId = swConfigId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
