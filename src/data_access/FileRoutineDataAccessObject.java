package data_access;

import use_case.adjust_setrep.AdjustSetRepDataAccessInterface;
import use_case.rename_routine.RenameRoutineDataAccessInterface;

import java.util.ArrayList;

public class FileRoutineDataAccessObject implements AdjustSetRepDataAccessInterface, RenameRoutineDataAccessInterface {
    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public void changeName(int id, String name) {

    }

    @Override
    public void updateRoutine(int id, ArrayList<Integer> sets, ArrayList<Integer> reps) {

    }
}
