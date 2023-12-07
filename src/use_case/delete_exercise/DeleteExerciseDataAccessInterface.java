package use_case.delete_exercise;

import entity.Routine;

public interface DeleteExerciseDataAccessInterface {
    boolean existsByName(String routineName);

    boolean existsById(String routineName, String exerciseName);

    void deleteExercise(String identifier, String exerciseName);

    Routine getRoutine(String routineName);
}
