package use_case.delete_exercise;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/
    private final String routineName;
    private final String exerciseName; // message: Added <name> to routine id
    private final Routine routine;

    public DeleteExerciseOutputData(String routineName, String exerciseName, Routine routine) {
        this.routineName = routineName;
        this.exerciseName = exerciseName;
        this.routine = routine;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getRoutineName() {
        return routineName;
    }

    public Routine getRoutine() {return routine;}

}
