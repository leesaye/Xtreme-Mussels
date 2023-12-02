package use_case.add_routine;


public interface AddRoutineOutputBoundary {
    void prepareSuccessView(AddRoutineOutputData addRoutineOutputData);


    void prepareFailView(String error);
}
