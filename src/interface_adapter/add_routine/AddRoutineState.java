package interface_adapter.add_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class AddRoutineState {
    private String routineName = "";
    private String routineNameError = null;
    private Routine routine = null;
    private String[][] routinesDisplay = null;

    private ArrayList<Routine> routines;

    private String[][] exercisesDisplay;



    public AddRoutineState() {
    }
    public String getRoutineName(){
        return routineName;
    }
    public String getRoutineNameError() {
        return routineNameError;
    }
    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }
    public void setRoutineNameError(String routineNameError) {
        this.routineNameError = routineNameError;
    }

    public void setRoutines(ArrayList<Routine> routines) { this.routines = routines; }

    public String[][] getRoutinesDisplay() {
        return routinesDisplay;
    }

    public void setRoutinesDisplay() {
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
        // if (routines.isEmpty()) {
        if (routines == null) {
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