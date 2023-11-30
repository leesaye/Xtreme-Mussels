package use_case.adjust_setrep;

import entity.Exercise;

import java.util.ArrayList;

public class AdjustSetRepInputData {
    final private int id;

    final private ArrayList<Integer> sets;

    final private ArrayList<Integer> reps;

    public AdjustSetRepInputData(int id, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        this.id = id;
        this.sets = sets;
        this.reps = reps;
    }

    public int getId() { return id; }

    public ArrayList<Integer> getSets() { return sets; }

    public ArrayList<Integer> getReps() { return reps; }
}
