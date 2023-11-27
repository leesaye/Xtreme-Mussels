package use_case.add_routine;

import java.util.ArrayList;
import java.util.Map;

public class AddRoutineInputData {
    private final String routineName;
    // private final ArrayList exercisesList;
    public AddRoutineInputData(String routineName) { // ArrayList<Map<String, Object>> exercisesList
        this.routineName = routineName;
    }

    public String getRoutineName() {
        return routineName;
    }
    // public ArrayList<Map<String, Object>> getExercisesList() {
        // return exercisesList;
    //}
}
