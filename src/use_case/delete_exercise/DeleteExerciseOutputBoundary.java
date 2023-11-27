package use_case.delete_exercise;

public interface DeleteExerciseOutputBoundary {
    void prepareSuccessView(DeleteExerciseOutputData data);

    void prepareFailView(String error);
}
