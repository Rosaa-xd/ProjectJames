package com.projectjames.lightservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectjames.lightservice.model.lightbulb.LightBulb;
import com.projectjames.lightservice.util.Request;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Slf4j
@Service
public class LightsService {
    private static String FILE = System.getProperty("user.home") +
            "/ProjectJames/lights.json";
    //private final static Logger logger = LoggerFactory.getLogger(LightsService.class);

    public void turnOffDeskLampRose(boolean state, int light) {
        String body = "{\"on\":" + state +"}";
        Request.request(
                "/lights/" + light + "/state",
                null,
                body,
                HttpMethod.PUT
        );
        log.info("Requesting to turn off the desk light");
    }

    public void blink(boolean startState, int loop, int light) throws InterruptedException {
        for (int i = 0; i < loop; i++) {
            String body = "{\"on\":" + startState + "}";
            Request.request(
                    "/lights/" + light + "/state",
                    null,
                    body,
                    HttpMethod.PUT
            );
            startState = !startState;
            Thread.sleep(1000);
        }
    }

    public HashMap<Integer, LightBulb> getLights() {
        String endPoint = "/lights";
        ResponseEntity response = Request.request(
                endPoint, null, null, HttpMethod.GET
        );
        log.info("Requesting info of all lights");

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getBody().toString(), new TypeReference<HashMap<Integer, LightBulb>>() {
            });
        } catch (JsonProcessingException | NullPointerException e) {
            e.printStackTrace();
            log.error("An error occurred when retrieving information on all lights");
            return null;
        }
    }
}
