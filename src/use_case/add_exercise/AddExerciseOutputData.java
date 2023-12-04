package use_case.add_exercise;

import java.util.ArrayList;
import entity.Exercise;
import entity.Routine;

public class AddExerciseOutputData {

    private final String routineName;
    private final String exerciseName; // message: Added <name> to routine id

    public AddExerciseOutputData(String routineName, String exerciseName) {

        this.routineName= routineName;
        this.exerciseName =  exerciseName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getRoutineName() {
        return routineName;
    }

    // get routine, exercises necessary?
}
