package interface_adapter.add_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class AddExerciseState {
    private String name;

    private String routine_name;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public AddExerciseState() {
    }

    public String getRoutineName() {return routine_name;}

    public void setRoutineName(String routine_name) {
        this.routine_name= routine_name;
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
