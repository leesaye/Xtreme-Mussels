package use_case.adjust_setrep;

import entity.Exercise;

import java.util.ArrayList;

public interface AdjustSetRepDataAccessInterface {
    boolean existsById(int id);

    void updateRoutine(int id, ArrayList<Exercise> exercises);
}
