package use_case.lookup_routine;

import entity.Routine;

public class LookUpRoutineOutputData {
    private final Routine routine;
    private boolean useCaseFailed;

    public LookUpRoutineOutputData(Routine routine, boolean useCaseFailed) {
        this.routine = routine;
        this.useCaseFailed = useCaseFailed;
    }

    public Routine getRoutine() {
        return routine;
    }
}
