package use_case.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/

    private final String routineName;
    private final String exerciseName; // message: Added <name> to routineName
    public DeleteExerciseOutputData(String routineName, String exerciseName) {

        this.routineName = routineName;
        this.exerciseName = exerciseName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getRoutineName() {
        return routineName;
    }

}
