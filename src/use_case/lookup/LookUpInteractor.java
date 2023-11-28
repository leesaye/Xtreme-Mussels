package use_case.lookup;

public class LookUpInteractor implements LookUpInputBoundary {
    final LookUpDataAccessInterface exerciseDataAccessObject;
    final LookUpOutputBoundary exercisePresenter;

    public LookUpInteractor(LookUpDataAccessInterface exerciseDataAccessObject, LookUpOutputBoundary exercisePresenter) {
        this.exerciseDataAccessObject = exerciseDataAccessObject;
        this.exercisePresenter = exercisePresenter;
    }


    @Override
    public void execute(LookUpInputData lookUpInputData) {

    }
}
