package entity;

import java.util.*;

public class Routine {
    private String routineName;

    private ArrayList<Exercise> exercisesList;

    public Routine(String routineName, ArrayList<Exercise> exercisesList) {
        this.routineName = routineName;
        this.exercisesList = exercisesList;
    }

    public String getRoutineName() {
        return routineName;
    }

    public ArrayList<Exercise> getExercisesList() {
        return exercisesList;
    }
}
