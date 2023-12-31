package interface_adapter.delete_exercise;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class DeleteExerciseState {
    private String routineName;

    private String exerciseName;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    private String[][] exercisesDisplay;

    private Routine routine;

    public DeleteExerciseState() {
    }

    public String getName() {
        return routineName;
    }

    public void setName(String name) {
        this.routineName = name;
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

    public String[][] getExercisesDisplay() {
        return exercisesDisplay;
    }

    public void setRoutine(Routine routine) { this.routine = routine; }

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
