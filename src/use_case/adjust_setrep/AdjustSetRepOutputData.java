package use_case.adjust_setrep;

import entity.Routine;

public class AdjustSetRepOutputData {
    private final String name;
    private final Routine routine;

    public AdjustSetRepOutputData(String name, Routine routine) {
        this.name = name;
        this.routine = routine;
    }

    public String getName() {
        return name;
    }

    public Routine getRoutine() { return routine; }
}
