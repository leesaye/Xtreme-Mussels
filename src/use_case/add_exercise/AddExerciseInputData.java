package use_case.add_exercise;

import java.util.ArrayList;

public class AddExerciseInputData {
    final private String routine_name;

    final private String exercise_name;


    public AddExerciseInputData(String routine_name, String name) {
        this.routine_name = routine_name;
        this.exercise_name = name;
    }

    public String getRoutineName() {
        return routine_name;
    }

    public String getExerciseName() {
        return exercise_name;
    }


}
