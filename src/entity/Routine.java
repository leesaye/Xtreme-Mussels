package entity;

import java.util.ArrayList;

public class Routine {
    private final String routineName;  // routine name cannot be repeated?
    private final ArrayList routine;  // list of exercises


    public Routine(String routineName, ArrayList routine) {
        this.routineName = routineName;
        this.routine = routine;
    }

    public String getRoutineName() {
        return routineName;
    }
    public ArrayList getRoutine() {
        return routine;
    }
}
