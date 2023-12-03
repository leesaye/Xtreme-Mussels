package use_case.lookup_routine;

public interface LookUpRoutineOutputBoundary {
    void prepareSuccessView(LookUpRoutineOutputData routine);

    void prepareFailView(String error);
}
