package entity;

import java.util.*;

public class Routine {
    private int id;
    private String routineName;
    private ArrayList<Map<String, Object>> exercisesList;

    public Routine(int id, String routineName, ArrayList<Map<String, Object>> exercisesList) {
        this.id = id;
        this.routineName = routineName;
        this.exercisesList = exercisesList;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return routineName;
    }
    public ArrayList<Map<String, Object>> getExercisesList() {
        return exercisesList;
    }
}