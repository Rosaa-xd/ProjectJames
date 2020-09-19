package com.projectjames.lightservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectjames.lightservice.model.lightbulb.LightBulb;
import com.projectjames.lightservice.util.Request;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class LightsService {
    private static String FILE = System.getProperty("user.home") +
            "/ProjectJames/lights.json";

    public ResponseEntity<?> turnOffDeskLampRose(boolean state) {
        String body = "{\"on\":" + state +"}";
        return Request.request(
                "/lights/13/state",
                null,
                body,
                HttpMethod.PUT
        );
    }

    public void blink(boolean startState, int loop) throws InterruptedException {
        for (int i = 0; i < loop; i++) {
            String body = "{\"on\":" + startState + "}";
            Request.request(
                    "/lights/13/state",
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

        try {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getBody().toString(), new TypeReference<HashMap<Integer, LightBulb>>() {
            });
        } catch (JsonProcessingException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
