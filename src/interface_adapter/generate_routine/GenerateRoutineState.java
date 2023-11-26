package interface_adapter.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public class GenerateRoutineState {
    private String errorMessage;
    private ArrayList<Exercise> routineList;

    public GenerateRoutineState(GenerateRoutineState copy) {
        routineList = copy.routineList;
        errorMessage = copy.errorMessage;
    }

    public GenerateRoutineState() {}

    public ArrayList<Exercise> getRoutineList() {
        return routineList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setRoutineList(ArrayList<Exercise> routineList) {
        this.routineList = routineList;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
