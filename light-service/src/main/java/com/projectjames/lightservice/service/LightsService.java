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
                "/lights/4/state",
                null,
                body,
                HttpMethod.PUT
        );
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

    public String writeTestJsonFile() {
        try {

            HashMap<Integer, String> lights = new HashMap<>();
            lights.put(1, "Sta Lamp Living");
            lights.put(2, "Sta Lamp");
            lights.put(3, "Bureau Baldwin");
            lights.put(4, "Bureau Roos");
            lights.put(5, "Plafond Lamp Kamer");
            lights.put(6, "Plafond Lamp Woonkamer");
            lights.put(7, "Philips");
            lights.put(8, "Wastafel");
            lights.put(9, "Overloop1");
            lights.put(10, "Overloop2");
            lights.put(11, "Overloop3");

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writeValue(new File(FILE), lights);

            return FILE;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "00p something went wrong!";
        }
    }

    public void importJsonFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<Integer, String> lights = new HashMap<>();

            lights = objectMapper.readValue(new File(FILE), HashMap.class);
            for (Map.Entry entry : lights.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " ; light name: " + entry.getValue());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
