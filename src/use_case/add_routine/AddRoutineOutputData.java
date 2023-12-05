package use_case.add_routine;


import entity.Routine;

import java.util.ArrayList;
import java.util.Map;


public class AddRoutineOutputData {
    private final String routineName;
    private boolean useCaseFailed;
    private ArrayList<Routine> routines;
    public AddRoutineOutputData(String routineName, boolean useCaseFailed, ArrayList<Routine> routines) {
        this.routineName = routineName;
        this.useCaseFailed = useCaseFailed;
        this.routines = routines;
    }
    public String getRoutineName() {
        return routineName;
    }

    public ArrayList<Routine> getAllRoutines() {
        return routines;
    }
}
