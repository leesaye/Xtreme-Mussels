package interface_adapter.lookup;

import entity.Exercise;

import java.util.ArrayList;

public class LookUpState {
    private ArrayList<Exercise> exercises = null;
    private ArrayList<String> exercisesDisplay = null;
    private String exercisesError = null;
    private String exercisesDisplayError = null;

    public LookUpState() {
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public String getExercisesError() {
        return exercisesError;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setExercisesError(String exercisesError) {
        this.exercisesError = exercisesError;
    }

    public ArrayList<String> getExercisesDisplay() {
        return exercisesDisplay;
    }

    public String getExercisesDisplayError() {
        return exercisesDisplayError;
    }

    public void setExercisesDisplay(ArrayList<Exercise> exercises) {
        this.exercisesDisplay = this.toStringArray(exercises);
    }

    public void setExercisesDisplayError(String exercisesDisplayError) {
        this.exercisesDisplayError = exercisesDisplayError;
    }

    public ArrayList<String> toStringArray(ArrayList<Exercise> exercise) {
        ArrayList<String> display = new ArrayList<>();
        for (Exercise value : exercise) {
            display.add("Name: " + value.getName() +
                    "\nTarget muscle: " + value.getTarget() +
                    "\nEquipment: " + value.getEquipment() +
                    "\nInstructions: " + value.getInstructions().toString());
        }
        return display;
    }
}
