package use_case.lookup_routine;

import entity.Routine;

public interface LookUpRoutineDataAccessInterface {
    boolean existsByName(String name);
    Routine getRoutine(String name);
}
