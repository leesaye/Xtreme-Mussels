package entity;

import java.util.*;

public class Routine {
    private int id;
    private String name;
    private ArrayList<Map<String, Object>> exercisesList;

    public Routine(int id, String name, ArrayList<Map<String, Object>> exercisesList) {
        this.id = id;
        this.name = name;
        this.exercisesList = exercisesList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Map<String, Object>> getExercisesList() {
        return exercisesList;
    }
}

