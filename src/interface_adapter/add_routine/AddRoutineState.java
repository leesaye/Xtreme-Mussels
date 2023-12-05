package interface_adapter.add_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class AddRoutineState {
    private String routineName = "";
    private String routineNameError = null;
    private Routine routine = null;
    private String[][] exercisesDisplay;

//    public AddRoutineState(AddRoutineState copy) {
//        routineName = copy.routineName;
//        routineNameError = copy.routineNameError;
//    }

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
    public void setExercisesDisplay() {
        this.exercisesDisplay = this.toStringArray(routine, routine.getExercisesList());
    }

    public String[][] toStringArray(Routine routine, ArrayList<Exercise> exercise) {
        if (exercise.isEmpty()) {
            return new String[][]{{routine.getRoutineName()}};
        }

        String[][] display = new String[exercise.size()][4];
        for (int i = 0; i < exercise.size(); i++) {
            String [] row = {routine.getRoutineName(), exercise.get(i).getTarget(), exercise.get(i).getName()};
            display[i] = row;
        }
        return display;
    }
}
