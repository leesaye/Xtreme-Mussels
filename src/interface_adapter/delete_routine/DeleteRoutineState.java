package interface_adapter.delete_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class DeleteRoutineState {
    private String routineName;

    private String nameError;

    public DeleteRoutineState() {
    }

    public String getName() {
        return routineName;
    }

    public void setName(String name) {
        this.routineName = name;
    }

    public void deleteRoutineNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }
}
