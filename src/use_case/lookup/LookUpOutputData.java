package use_case.lookup;

import entity.Exercise;

import java.util.ArrayList;

public class LookUpOutputData {
    private final ArrayList<Exercise> exercises;
    private boolean useCaseFailed;

    public LookUpOutputData(ArrayList<Exercise> exercises, boolean useCaseFailed) {
        this.exercises = exercises;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
