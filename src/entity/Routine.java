package entity;

import java.util.*;

public class Routine {
    private String name;

    private ArrayList<Exercise> exercisesList;

    public Routine() {}

    public Routine(String name, ArrayList<Exercise> exercisesList) {
        this.name = name;
        this.exercisesList = exercisesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercisesList() {
        return exercisesList;
    }

    public void setExercisesList(ArrayList<Exercise> exercisesList) {
        this.exercisesList = exercisesList;
    }
}

