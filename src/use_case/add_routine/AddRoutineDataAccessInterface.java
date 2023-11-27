package use_case.add_routine;

import entity.Routine;
import entity.User;

import java.util.ArrayList;
import java.util.Map;

public interface AddRoutineDataAccessInterface {
    boolean existsByName(String identifier);
    ArrayList<Map<String, Object>> addRoutine();
    void save(Routine routine);
}