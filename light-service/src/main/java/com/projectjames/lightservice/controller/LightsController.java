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
    public void turnOff(@RequestParam boolean state) {
        lightsService.turnOffDeskLampRose(state);
    }

    @GetMapping("/lights")
    public HashMap<Integer, LightBulb> getLights() {
        return lightsService.getLights();
    }

    @PutMapping("/blink")
    public void blink(@RequestParam boolean startState, @RequestParam int loop) throws InterruptedException {
        lightsService.blink(startState, loop);
    }
}
