package interface_adapter.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseState {
    private String routineName;

    private String exerciseName;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public DeleteExerciseState() {
    }

    public String getName() {
        return routineName;
    }

    public void setName(String name) {
        this.routineName = routineName;
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
