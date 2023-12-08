package use_case.delete_routine;

public interface DeleteRoutineOutputBoundary {
    void prepareSuccessView(DeleteRoutineOutputData data);

    void prepareFailView(String error);
}
