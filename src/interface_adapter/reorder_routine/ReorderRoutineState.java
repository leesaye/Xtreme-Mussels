package interface_adapter.reorder_routine;

import entity.Exercise;

import java.util.ArrayList;

public class ReorderRoutineState {

    private String name;

    private int id;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public ReorderRoutineState() {
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoutineName(String name) {
        this.name = name;
    }

    public String getRoutineName() {
        return name;
    }

    public void setRoutineNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }
}
