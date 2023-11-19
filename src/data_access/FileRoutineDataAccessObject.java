package data_access;

import entity.Exercise;
import use_case.reorder_routine.ReorderRoutineDataAccessInterface;

import java.util.ArrayList;

public class FileRoutineDataAccessObject implements ReorderRoutineDataAccessInterface {
    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public void updateRoutine(int id, ArrayList<Exercise> exercises) {

    }
}
