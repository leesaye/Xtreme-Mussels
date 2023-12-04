package interface_adapter.add_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class AddExerciseState {
    private String name;

    private String routineName;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public AddExerciseState() {
    }

    public String getRoutineName() {return routineName;}

    public void setRoutineName(String routineName) {this.routineName= routineName;}

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
