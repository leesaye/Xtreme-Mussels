package use_case.reorder_routine;

import entity.Exercise;

import java.util.ArrayList;

public class ReorderRoutineInputData {

    final private String name;

    final private int id;

    final private ArrayList<Integer> reps;

    final private ArrayList<Integer> sets;

    final private ArrayList<Exercise>  exercises;

    public ReorderRoutineInputData(String name, int id, ArrayList<Integer> reps,
                                   ArrayList<Integer> sets, ArrayList<Exercise> exercises ) {
        this.name = name;
        this.id = id;
        this.reps = reps;
        this.sets = sets;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    public ArrayList<Integer> getReps() {
        return reps;
    }

    public ArrayList<Integer> getSets() {
        return sets;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
