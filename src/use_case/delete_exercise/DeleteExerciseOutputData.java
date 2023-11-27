package use_case.delete_exercise;

import entity.Exercise;

import java.util.ArrayList;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/

    private final int id;
    private final String name; // message: Added <name> to routine id
    private final ArrayList<Exercise> exercises;
    public DeleteExerciseOutputData(int id, String name, ArrayList<Exercise> exercises) {

        this.id = id;
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
