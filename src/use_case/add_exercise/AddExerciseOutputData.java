package use_case.add_exercise;

import java.util.ArrayList;
import entity.Exercise;
import entity.Routine;

public class AddExerciseOutputData {

    private final int id;
    private final String name; // message: Added <name> to routine id

    private final ArrayList<Exercise> exercises;
    public AddExerciseOutputData(int id, String name, ArrayList<Exercise> exercises) {

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

    // get routine necessary?
}
