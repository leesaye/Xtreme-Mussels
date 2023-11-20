package use_case.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public interface GenerateRoutineDataAccessInterface {
    ArrayList<Exercise> getExercisesByTarget(String target, int numberOfExercises);
}
