package use_case.add_routine;

import java.util.ArrayList;
import java.util.Map;

public class AddRoutineInputData {
    private final int id;
    private final String routineName;
    private final ArrayList<Map<String, Object>> exercisesList;
    public AddRoutineInputData(int id, String routineName, ArrayList<Map<String, Object>> exercisesList) {
        this.id = id;
        this.routineName = routineName;
        this.exercisesList = exercisesList;
    }

    public int getId() {
        return id;
    }
    public String getRoutineName() {
        return routineName;
    }
    public ArrayList<Map<String, Object>> getExercisesList() {
        return exercisesList;
    }
}
