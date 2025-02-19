package com.example.lifeprediction;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allows frontend to call API
public class LifePredictionController {

    @Autowired
    private DeathPredictionService deathPredictionService;

    @PostMapping("/predict")
    public Map<String, String> predictDeath(@RequestBody Map<String, Integer> requestBody) {
        int age = requestBody.get("age");

        if (age <= 0 || age >= 100) {
            return Map.of("error", "Invalid age. Must be between 1 and 99.");
        }

        String deathDate = deathPredictionService.predictDeathDate(age);
        return Map.of("death_date", deathDate);
    }
}
