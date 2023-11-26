package use_case.rename_routine;

public interface RenameRoutineOutputBoundary {
    void prepareSuccessView(RenameRoutineOutputData data);

    void prepareFailView(String error);
}
