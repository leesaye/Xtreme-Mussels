package use_case.adjust_setrep;

import entity.Exercise;

import java.util.ArrayList;

public class AdjustSetRepInputData {
    final private int id;

    final private ArrayList<Exercise>  exercises;

    public AdjustSetRepInputData(int id, ArrayList<Exercise> exercises ) {
        this.id = id;
        this.exercises = exercises;
    }

    public int getId() { return id; }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
