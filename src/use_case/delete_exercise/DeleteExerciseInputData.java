package use_case.delete_exercise;

public class DeleteExerciseInputData {
    final private String routine_name;

    final private String exercise_name;


    public DeleteExerciseInputData(String routine_name, String exercise_name) {
        this.routine_name = routine_name;
        this.exercise_name = exercise_name;
    }

    public String getRoutineName() {
        return routine_name;
    }

    public String getExerciseName() {
        return exercise_name;
    }
}
