package use_case.edit_routine;

public interface EditRoutineOutputBoundary {
    void prepareSuccessView(EditRoutineOutputData data);

    void prepareFailView(String error);
}
