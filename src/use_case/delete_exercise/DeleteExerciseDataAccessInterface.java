package use_case.delete_exercise;

import entity.Routine;

public interface DeleteExerciseDataAccessInterface {
    boolean existsByName(String routine_name);

    //dependent on implementation- current, likely will change: search for exercise to delete it
    // maybe have [x]s next to each exercise in the view/delete?
    boolean existsById(String routine_name, String exercise_name);

    //note: discuss implementation, possible exception/changing to take a name
    void deleteExercise(String identifier, String exerciseName);

    Routine getRoutine(String routineName);
}
