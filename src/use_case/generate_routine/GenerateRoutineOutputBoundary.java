package use_case.generate_routine;

public interface GenerateRoutineOutputBoundary {

    public void prepareSuccessView(GenerateRoutineOutputData generateRoutineOutputData);

    public void prepareFailedView(String message);
}
