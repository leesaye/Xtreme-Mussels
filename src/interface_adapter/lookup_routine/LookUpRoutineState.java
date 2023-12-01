package interface_adapter.lookup_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class LookUpRoutineState {
    private Routine routine = null;
    private ArrayList<String> exercisesDisplay = null;
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

    public ArrayList<String> getExercisesDisplay() {
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

    public ArrayList<String> toStringArray(ArrayList<Exercise> exercise) {
        ArrayList<String> display = new ArrayList<>();
        for (Exercise value : exercise) {
            display.add("Name: " + value.getName() +
                    "\nEquipment: " + value.getEquipment() +
                    "\nSets x Reps: " + value.getSets() + "x" + value.getReps() +
                    "\nInstructions: " + value.getInstructions().toString() + "\n\n");
        }
        return display;
    }

}
