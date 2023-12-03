package use_case.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/

    private final String routine_name;
    private final String exercise_name; // message: Added <name> to routine id
    public DeleteExerciseOutputData(String routine_name, String name) {

        this.routine_name = routine_name;
        this.exercise_name = name;
    }

    public String getExerciseName() {
        return exercise_name;
    }

    public String getRoutineName() {
        return routine_name;
    }

}
