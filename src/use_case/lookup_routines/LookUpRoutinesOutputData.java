package use_case.lookup_routines;

import entity.Routine;

import java.util.ArrayList;

public class LookUpRoutinesOutputData {
    private final ArrayList<Routine> routines;

    // No useCaseFailed, assumes will always be successful (outputs empty list if empty)
    public LookUpRoutinesOutputData(ArrayList<Routine> routines) {
        this.routines = routines;
    }

    public ArrayList<Routine> getAllRoutines() {
        return routines;
    }
}
