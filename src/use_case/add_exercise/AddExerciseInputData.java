package use_case.add_exercise;

import java.util.ArrayList;

public class AddExerciseInputData {
    final private String routineName;

    final private String exerciseName;


    public AddExerciseInputData(String routineName, String exerciseName){
        this.routineName = routineName;
        this.exerciseName = exerciseName;
    }

    public String getRoutineName() {
        return routineName;
    }

    public String getExerciseName() {
        return exerciseName;
    }


}
