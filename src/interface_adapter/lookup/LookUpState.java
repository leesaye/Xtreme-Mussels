package interface_adapter.lookup;

import data_access.ApiDataAccessObject;
import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.RoutineFactory;

import java.util.ArrayList;

public class LookUpState {
    private ArrayList<Exercise> exercises = null;
    private String[][] exercisesDisplay = null;
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

    public String[][] getExercisesDisplay() {
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

    public String[][] toStringArray(ArrayList<Exercise> exercise) {
        String[][] display = new String[exercise.size()][4];

        for (int i = 0; i < exercise.size(); i++) {
            String [] row = {exercise.get(i).getName(), exercise.get(i).getTarget(), exercise.get(i).getEquipment(), String.join("\n", exercise.get(i).getInstructions())};
            display[i] = row;
        }
        return display;
    }
}
