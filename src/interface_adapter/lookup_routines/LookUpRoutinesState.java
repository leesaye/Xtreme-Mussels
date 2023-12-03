package interface_adapter.lookup_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class LookUpRoutinesState {
    private Routine routine = null;
    private String[][] exercisesDisplay = null;
    private String routineError = null;
    private String exercisesDisplayError = null;

    public LookUpRoutinesState() {
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

    public String getExercisesDisplayError() {
        return exercisesDisplayError;
    }

    public void setExercisesDisplay(Routine routine) {
        this.exercisesDisplay = this.toStringArray(routine.getExercisesList());
    }

    public void setExercisesDisplayError(String exercisesDisplayError) {
        this.exercisesDisplayError = exercisesDisplayError;
    }

    public String[][] toStringArray(ArrayList<Exercise> exercise) {
        String[][] display = new String[exercise.size()][4];

        for (int i = 0; i < exercise.size(); i++) {
            String [] row = {exercise.get(i).getName(), Integer.toString(exercise.get(i).getSets()), Integer.toString(exercise.get(i).getReps())};
            display[i] = row;
        }
        return display;
    }

}
