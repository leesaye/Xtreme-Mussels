package use_case.delete_exercise;

public class DeleteExerciseInputData {
    final private String routineName;

    final private String exerciseName;


    public DeleteExerciseInputData(String routineName, String exerciseName) {
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
