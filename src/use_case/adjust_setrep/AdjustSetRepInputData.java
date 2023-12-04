package use_case.adjust_setrep;

import java.util.ArrayList;

public class AdjustSetRepInputData {
    final private String id;

    final private ArrayList<Integer> sets;

    final private ArrayList<Integer> reps;

    public AdjustSetRepInputData(String id, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        this.id = id;
        this.sets = sets;
        this.reps = reps;
    }

    public String getId() { return id; }

    public ArrayList<Integer> getSets() { return sets; }

    public ArrayList<Integer> getReps() { return reps; }
}
