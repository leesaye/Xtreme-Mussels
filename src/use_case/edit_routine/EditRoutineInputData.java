package use_case.edit_routine;

import entity.Exercise;

import java.util.ArrayList;

public class EditRoutineInputData {

    final private String name;

    final private ArrayList<Integer> reps;

    final private ArrayList<Integer> sets;

    final private ArrayList<Exercise>  exercises;

    public EditRoutineInputData(String name, ArrayList<Integer> reps,
                                ArrayList<Integer> sets, ArrayList<Exercise> exercises ) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

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
