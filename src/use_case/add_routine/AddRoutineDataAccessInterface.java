package use_case.add_routine;

import entity.Routine;
import entity.User;

public interface AddRoutineDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Routine routine);
}
