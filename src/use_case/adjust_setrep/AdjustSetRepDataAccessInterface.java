package use_case.adjust_setrep;

import entity.Routine;

import java.util.ArrayList;

public interface AdjustSetRepDataAccessInterface {
    boolean existsByName(String id);

    void updateRoutine(String id, ArrayList<Integer> sets, ArrayList<Integer> reps);

    Routine getRoutine(String id);
}
