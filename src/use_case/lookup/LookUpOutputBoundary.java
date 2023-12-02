package use_case.lookup;

public interface LookUpOutputBoundary {
    void prepareSuccessView(LookUpOutputData exercises);

    void prepareFailView(String error);
}
