package use_case.delete_exercise;

public interface DeleteExerciseDataAccessInterface {
    boolean existsByName(String routineName);

    //dependent on implementation- current, likely will change: search for exercise to delete it
    // maybe have [x]s next to each exercise in the view/delete?
    boolean existsById(String routineName, String exerciseName);

    //note: discuss implementation, possible exception/changing to take a name
    void deleteExercise(String identifier, String exerciseName);

}
