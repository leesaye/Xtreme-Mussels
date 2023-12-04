package use_case.delete_exercise;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/

    private final String routine_name;
    private final String exercise_name; // message: Added <name> to routine id

    private final Routine routine;

    public DeleteExerciseOutputData(String routine_name, String name, Routine routine) {
        this.routine_name = routine_name;
        this.exercise_name = name;
        this.routine = routine;
    }

    public String getExerciseName() {
        return exercise_name;
    }

    public String getRoutineName() {
        return routine_name;
    }

    public Routine getRoutine() { return routine; }

}
