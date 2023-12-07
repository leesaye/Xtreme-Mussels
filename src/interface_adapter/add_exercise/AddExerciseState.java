package interface_adapter.add_exercise;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class AddExerciseState {
    private String name;

    private String routineName;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    private Routine routine;

    private String[][] exercisesDisplay;

    private boolean useCaseSuccess;

    public AddExerciseState() {
    }

    public String getName() {return name; }

    public void setName(String exerciseName) {this.name = exerciseName;}

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

    public void setRoutine(Routine routine) { this.routine = routine; }

    public String[][] getExercisesDisplay() { return exercisesDisplay; }

    public void setExercisesDisplay() {
        this.exercisesDisplay = this.toStringArray(routine.getExercisesList());
    }

    public void setUseCaseSuccess(boolean useCaseSuccess) { this.useCaseSuccess = useCaseSuccess; }

    public boolean getUseCaseSuccess() { return useCaseSuccess; }

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
