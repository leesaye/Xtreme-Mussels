package interface_adapter.adjust_setrep;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class AdjustSetRepState {

    private String name;

    private String id;

    private ArrayList<Exercise> exercises = null;

    private Routine routine;

    private String[][] exercisesDisplay;

    private String nameError;

    public AdjustSetRepState() {
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setRoutineName(String name) {
        this.name = name;
    }

    public String getRoutineName() {
        return name;
    }

    public void setRoutineNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public String[][] getExercisesDisplay() {
        return exercisesDisplay;
    }

    public void setExercisesDisplay() {
        this.exercisesDisplay = this.toStringArray(routine.getExercisesList());
    }

    public String[][] toStringArray(ArrayList<Exercise> exercise) {
        if (exercise.isEmpty()) {
            return new String[][]{{}};
        }

        String[][] display = new String[exercise.size()][4];
        for (int i = 0; i < exercise.size(); i++) {
            String [] row = {exercise.get(i).getName(), Integer.toString(exercise.get(i).getSets()), Integer.toString(exercise.get(i).getReps())};
            display[i] = row;
        }
        return display;
    }
}
