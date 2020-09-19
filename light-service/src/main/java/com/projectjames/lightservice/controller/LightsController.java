package com.projectjames.lightservice.controller;

import com.projectjames.lightservice.model.lightbulb.LightBulb;
import com.projectjames.lightservice.service.LightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class LightsController {

    @Autowired
    private LightsService lightsService;

    @PutMapping("/turnOff")
    public ResponseEntity<?> turnOff(@RequestParam boolean state) {
        return lightsService.turnOffDeskLampRose(state);
    }

    @GetMapping("/test")
    public String test() {
        return lightsService.writeTestJsonFile();
    }

    @GetMapping("/import")
    public void testJson() {
        lightsService.importJsonFile();
    }

    @GetMapping("/lights")
    public HashMap<Integer, LightBulb> getLights() {
        return lightsService.getLights();
    }
}
