package entity;

import java.util.*;

public class Routine {
    private final int id;
    private final String routineName;  // routine name cannot be repeated?
    private final ArrayList<Map<String, Object>> exercisesList;  // list of exercises


    public Routine(int id, String routineName, ArrayList<Map<String, Object>> exercisesList) {
        this.id = id;
        this.routineName = routineName;
        this.exercisesList = exercisesList;
    }

    public int getId() {
        return id;
    }
    public String getRoutineName() {
        return routineName;
    }
    public ArrayList<Map<String, Object>> getExercisesList() {
        return exercisesList;
    }
}