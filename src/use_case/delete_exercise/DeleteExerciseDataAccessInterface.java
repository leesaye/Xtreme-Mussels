package use_case.delete_exercise;

public interface DeleteExerciseDataAccessInterface {
    boolean existsById(int id);

    //dependent on implementation- current, likely will change: search for exercise to delete it
    // maybe have [x]s next to each exercise in the view/delete?
    boolean existsByName(String exercise_name);

    void updateRoutine(int id, String name);

}
