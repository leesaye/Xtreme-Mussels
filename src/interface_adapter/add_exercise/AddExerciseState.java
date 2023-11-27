package interface_adapter.add_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class AddExerciseState {
    private String name;

    private int id;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public AddExerciseState() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void addExerciseNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }


}
