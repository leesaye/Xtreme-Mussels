package interface_adapter.lookup;

import entity.Exercise;

import java.util.ArrayList;

public class LookUpState {
    private ArrayList<Exercise> exercises = null;
    private String exercisesError;
    private String[][] exercisesDisplay = null;

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

    public String[][] getExercisesDisplay() {
        return exercisesDisplay;
    }

    public void setExercisesDisplay(ArrayList<Exercise> exercises) {
        this.exercisesDisplay = this.toStringArray(exercises);
    }

    public String[][] toStringArray(ArrayList<Exercise> exercise) {
        if (exercise.isEmpty()) {
            return new String[][]{{}};
        }

        String[][] display = new String[exercise.size()][4];

        for (int i = 0; i < exercise.size(); i++) {
            String [] row = {exercise.get(i).getName(), exercise.get(i).getTarget(), exercise.get(i).getEquipment(), String.join("\n", exercise.get(i).getInstructions())};
            display[i] = row;
        }
        return display;
    }
}
