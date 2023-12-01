package interface_adapter.lookup;

import use_case.lookup.LookUpInputBoundary;
import use_case.lookup.LookUpInputData;

public class LookUpController {
    final LookUpInputBoundary lookUpUseCaseInteractor;
    public LookUpController(LookUpInputBoundary lookUpUseCaseInteractor) {
        this.lookUpUseCaseInteractor = lookUpUseCaseInteractor;
    }

    public void execute(String value, String query) {
        LookUpInputData lookUpInputData = new LookUpInputData(value, query);
        lookUpUseCaseInteractor.execute(lookUpInputData);
    }
}
