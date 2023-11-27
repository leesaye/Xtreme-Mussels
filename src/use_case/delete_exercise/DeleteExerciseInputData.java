package use_case.delete_exercise;

public class DeleteExerciseInputData {
    final private int id;

    final private String exercise_name;


    public DeleteExerciseInputData(int id, String name) {
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
