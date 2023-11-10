package use_case.edit_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public interface EditRoutineDataAccessInterface {
    boolean existsById(int id);

    void updateRoutine(int id, String name, ArrayList<Exercise> exercises, ArrayList<Integer> reps, ArrayList<Integer> sets);
}
