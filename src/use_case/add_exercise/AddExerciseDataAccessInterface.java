package use_case.add_exercise;

import entity.Exercise;

import java.util.ArrayList;

public interface AddExerciseDataAccessInterface {
    boolean existsByName(String routineName);

    ArrayList<Exercise> getExercisesByName(String name, int numberOfExercises);

    void addExercise(String identifier, ArrayList<Exercise> exercises);

}
