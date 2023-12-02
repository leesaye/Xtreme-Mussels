package interface_adapter.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseState {
    private String routine_name;

    private String exercise_name;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public DeleteExerciseState() {
    }

    public String getName() {
        return routine_name;
    }

    public void setName(String name) {
        this.routine_name = routine_name;
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
