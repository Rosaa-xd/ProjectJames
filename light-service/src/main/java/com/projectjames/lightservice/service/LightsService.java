package com.projectjames.lightservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectjames.lightservice.util.Request;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
