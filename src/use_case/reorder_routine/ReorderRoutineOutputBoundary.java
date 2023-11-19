package use_case.reorder_routine;

public interface ReorderRoutineOutputBoundary {
    void prepareSuccessView(ReorderRoutineOutputData data);

    void prepareFailView(String error);
}
