package use_case.add_exercise;

import java.util.ArrayList;
import entity.Exercise;
import entity.Routine;

public class AddExerciseOutputData {

    private final String routineName;
    private final String exerciseName; // message: Added <name> to routine id
    private final Routine routine;

    public AddExerciseOutputData(String routineName, String exerciseName, Routine routine) {
        this.routineName = routineName;
        this.exerciseName = exerciseName;
        this.routine = routine;
    }

    public String getExerciseName() {return exerciseName;}

    public String getRoutineName() {return routineName;}

    public Routine getRoutine() {return routine;}

}
