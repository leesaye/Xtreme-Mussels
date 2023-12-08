package use_case.delete_routine;

import entity.Routine;

public class DeleteRoutineOutputData {
    private final String routineName;

    public DeleteRoutineOutputData(String routineName) {
        this.routineName = routineName;
    }

    public String getRoutineName() {
        return routineName;
    }

}
