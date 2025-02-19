package com.example.lifeprediction;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Random;

@Service
public class DeathPredictionService {

    public String predictDeathDate(int age) {
        TrinaryProcessor processor = new TrinaryProcessor();
        processor.setState("+/-10");
        String resolvedState = processor.resolveState();

        int lifeExpectancy = resolvedState.equals("+1") ? 100 : 60;
        Random random = new Random();
        int yearsRemaining = random.nextInt(lifeExpectancy - age) + 1;

        LocalDate deathDate = LocalDate.now().plusYears(yearsRemaining);
        return deathDate.toString();
    }
}
