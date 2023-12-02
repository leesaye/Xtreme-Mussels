package use_case.add_routine;

import java.util.ArrayList;
import java.util.Map;

public class AddRoutineOutputData {
    private final String routineName;
    private boolean useCaseFailed;
    public AddRoutineOutputData(String routineName, boolean useCaseFailed) {
        this.routineName = routineName;
        this.useCaseFailed = useCaseFailed;
    }
    public String getRoutineName() {
        return routineName;
    }
}
