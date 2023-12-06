package use_case.add_routine;

import entity.Routine;

import java.util.ArrayList;


public interface AddRoutineDataAccessInterface {
    boolean existsByName(String identifier);

    void addRoutine(Routine routine);

    ArrayList<Routine> getRoutines();
}
