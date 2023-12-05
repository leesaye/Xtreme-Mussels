package interface_adapter.lookup_routines;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class LookUpRoutinesState {
    private ArrayList<Routine> routines = new ArrayList<>();
    private String[][] routinesDisplay = null;
    private String routinesError;

    public LookUpRoutinesState() {
    }

    public ArrayList<Routine> getRoutines() {
        return routines;
    }

    public String getRoutinesError() {
        return routinesError;
    }

    public void setRoutines(ArrayList<Routine> routines) {
        this.routines = routines;
    }

    public void setRoutinesError(String routinesError) {
        this.routinesError = routinesError;
    }

    public String[][] getRoutinesDisplay() {
        return routinesDisplay;
    }

    public void setRoutinesDisplay(ArrayList<Routine> routines) {
        this.routinesDisplay = this.toRoutineStringArray();
    }

    public String toExerciseStringArray(ArrayList<Exercise> exercise) {
        String[] display = new String[exercise.size()];

        for (int i = 0; i < exercise.size(); i++) {
            display[i] = exercise.get(i).getName();
        }

        return String.join(", ", display);
    }

    public String[][] toRoutineStringArray() {
        if (routines.isEmpty()) {
            return new String[][]{{}};
        }

        String[][] display = new String[routines.size()][2];

        for (int i = 0; i < routines.size(); i++) {
            String [] row = {routines.get(i).getRoutineName(), toExerciseStringArray(routines.get(i).getExercisesList())};
            display[i] = row;
        }
        return display;
    }

}
