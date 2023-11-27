package use_case.add_exercise;

import java.util.ArrayList;

public class AddExerciseInputData {
    final private int id;

    final private String exercise_name;


    public AddExerciseInputData(int id, String name) {
        this.id = id;
        this.exercise_name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return exercise_name;
    }


}
