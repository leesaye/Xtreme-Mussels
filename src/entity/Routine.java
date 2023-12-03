package entity;

import java.util.*;

public class Routine {
    private String routineName;
    private ArrayList<Exercise> exercisesList;

    public Routine(String routineName) {
        this.routineName = routineName;
        this.exercisesList = new ArrayList<>();
    }

    public String getRoutineName() {
        return routineName;
    }
    public ArrayList<Exercise> getExercisesList() {
        return exercisesList;
    }

    public void setName(String name) {
        this.routineName = name;
    }

    public void setExercisesList(ArrayList<Exercise> exercisesList) {
        this.exercisesList = exercisesList;
    }
}
