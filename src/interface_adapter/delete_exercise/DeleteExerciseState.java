package interface_adapter.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseState {
    private String name;

    private int id;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public DeleteExerciseState() {
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

    public void deleteExerciseNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }

}
