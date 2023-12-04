package use_case.add_exercise;

import java.util.ArrayList;
import entity.Exercise;
import entity.Routine;

public class AddExerciseOutputData {

    private final String routine_name;
    private final String name; // message: Added <name> to routine id

    private final Routine routine;

    public AddExerciseOutputData(String routine_name, String name, Routine routine) {
        this.routine_name = routine_name;
        this.name = name;
        this.routine = routine;
    }

    public String getName() {
        return name;
    }

    public String getRoutineName() {
        return routine_name;
    }

    public Routine getRoutine() { return routine; }

    // get routine, exercises necessary?
}
