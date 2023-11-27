package use_case.add_routine;

import java.util.ArrayList;
import java.util.Map;

public class AddRoutineOutputData {
    private ArrayList<Map<String, Object>> exerciseList;

    public AddRoutineOutputData(ArrayList<Map<String, Object>> exercisesList) {
        this.exerciseList = exercisesList;
    }
}
