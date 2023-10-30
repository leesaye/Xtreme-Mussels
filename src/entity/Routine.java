package entity;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Routine {
    private LinkedHashMap<String, Integer> exercises;

    public Routine(LinkedHashMap exercises) {
        this.exercises = exercises;
    }
}