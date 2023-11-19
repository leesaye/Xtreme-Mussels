package use_case.reorder_routine;

import entity.Exercise;

import java.util.ArrayList;

public class ReorderRoutineInputData {

    final private String name;

    final private int id;

    final private ArrayList<Exercise>  exercises;

    public ReorderRoutineInputData(String name, int id, ArrayList<Exercise> exercises ) {
        this.name = name;
        this.id = id;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
