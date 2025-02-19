package com.example.lifeprediction;

import java.util.Random;

public class TrinaryProcessor {
    private String state;

    public void setState(String value) {
        if (value.equals("+1") || value.equals("-0") || value.equals("+/-10")) {
            this.state = value;
        } else {
            throw new IllegalArgumentException("Invalid state. Allowed states: '+1', '-0', '+/-10'");
        }
    }

    public String resolveState() {
        if (this.state.equals("+/-10")) {
            Random random = new Random();
            this.state = (random.nextDouble() >= 0.6) ? "+1" : "-0"; // 60% chance of +1, 40% of -0
        }
        return this.state;
    }

    public String getState() {
        return this.state;
    }
}
