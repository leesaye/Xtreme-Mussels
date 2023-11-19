package use_case.reorder_routine;

import entity.Exercise;

import java.util.ArrayList;

public class ReorderRoutineInputData {
    final private int id;

    final private ArrayList<Exercise>  exercises;

    public ReorderRoutineInputData(int id, ArrayList<Exercise> exercises ) {
        this.id = id;
        this.exercises = exercises;
    }

    public int getId() { return id; }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
