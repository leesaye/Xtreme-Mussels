package use_case.add_exercise;

public interface AddExerciseOutputBoundary {
    void prepareSuccessView(AddExerciseOutputData data);

    void prepareFailView(String error);
}
