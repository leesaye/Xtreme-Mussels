package use_case.reorder_routine;

import entity.Exercise;

import java.util.ArrayList;

public interface ReorderRoutineDataAccessInterface {
    boolean existsById(int id);

    void updateRoutine(int id, String name, ArrayList<Exercise> exercises, ArrayList<Integer> reps, ArrayList<Integer> sets);
}
