package use_case.adjust_setrep;

import entity.Exercise;

import java.util.ArrayList;

public interface AdjustSetRepDataAccessInterface {
    boolean existsByName(String id);

    void updateRoutine(String id, ArrayList<Integer> sets, ArrayList<Integer> reps);
}
