package data_access;

import entity.Exercise;
import use_case.adjust_setrep.AdjustSetRepDataAccessInterface;

import java.util.ArrayList;

public class FileRoutineDataAccessObject implements AdjustSetRepDataAccessInterface {
    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public void updateRoutine(int id, ArrayList<Integer> sets, ArrayList<Integer> reps) {

    }
}
