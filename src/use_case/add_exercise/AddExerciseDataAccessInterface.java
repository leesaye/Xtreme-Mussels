package use_case.add_exercise;

import java.util.ArrayList;

public interface AddExerciseDataAccessInterface {
    boolean existsById(int id);

    boolean existsByName(String exercise_name);

    void updateRoutine(int id, String name);

}
