package use_case.add_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;
import java.util.Map;

public interface AddRoutineDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Routine routine);
}
