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
        this.exercisesDisplay = this.toString(exercises);
    }

    public void setExercisesDisplayError() {
        this.exercisesDisplayError = exercisesDisplayError;
    }

    public ArrayList<String> toString(ArrayList<Exercise> exercise) {
        ArrayList<String> display = new ArrayList<>();
        for (int i = 0; i < exercises.size(); i++) {
            display.add("Name: " + exercise.get(i).getName() +
                    "\nTarget muscle: " + exercise.get(i).getTarget() +
                    "\n Equipment needed: " + exercise.get(i).getEquipment() +
                    "\n Instructions: " + exercise.get(i).getInstructions().toString());
        }
        return display;
    }
}
