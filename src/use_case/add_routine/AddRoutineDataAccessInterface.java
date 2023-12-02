package use_case.add_routine;

import entity.Routine;


public interface AddRoutineDataAccessInterface {
    boolean existsByName(String identifier);


    void save(Routine routine);
}
