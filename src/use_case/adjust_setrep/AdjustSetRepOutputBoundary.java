package use_case.adjust_setrep;

public interface AdjustSetRepOutputBoundary {
    void prepareSuccessView(AdjustSetRepOutputData data);

    void prepareFailView(String error);
}
