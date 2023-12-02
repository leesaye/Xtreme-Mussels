package use_case.add_exercise;

import java.util.ArrayList;
import entity.Exercise;
import entity.Routine;

public class AddExerciseOutputData {

    private final String routine_name;
    private final String name; // message: Added <name> to routine id

    public AddExerciseOutputData(String routine_name, String name) {

        this.routine_name = routine_name;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRoutineName() {
        return routine_name;
    }

    // get routine, exercises necessary?
}
