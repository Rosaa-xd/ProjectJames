package com.projectjames.lightservice.config;

import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "config")
@Validated
public class Config {
    public static String USERNAME;
    public static String IP_ADDRESS;
    private static final String PROPERTIES_LOCATION = System.getProperty("user.home") +
            "/ProjectJames/lightservice.properties";

    @SneakyThrows(IOException.class)
    public static void getConfig() {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTIES_LOCATION));
        USERNAME = properties.getProperty("username");
        IP_ADDRESS = properties.getProperty("ipaddress");
    }
}
