package interface_adapter.lookup_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class LookUpRoutineState {
    private Routine routine = null;
//    private ArrayList<String> exercisesDisplay = null;

    // Temporary to test it works
    private String[][] exercisesDisplay = {{"Exercise 1", "10", "2"}};

    private String routineError = null;
    private String exercisesDisplayError = null;

    public LookUpRoutineState() {
    }

    public Routine getRoutine() {
        return routine;
    }

    public String getRoutineError() {
        return routineError;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public void setRoutineError(String routineError) {
        this.routineError = routineError;
    }

    public String[][] getExercisesDisplay() {
        return exercisesDisplay;
    }

    public void setExercisesDisplay(Routine routine) {
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
