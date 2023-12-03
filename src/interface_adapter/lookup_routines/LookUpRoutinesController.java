package interface_adapter.lookup_routine;

import use_case.lookup_routines.LookUpRoutinesInputBoundary;

public class LookUpRoutinesController {
    final LookUpRoutinesInputBoundary lookUpRoutinesUseCaseInteractor;
    
    public LookUpRoutinesController(LookUpRoutinesInputBoundary lookUpRoutinesUseCaseInteractor) {
        this.lookUpRoutinesUseCaseInteractor = lookUpRoutinesUseCaseInteractor;
    }

    public void execute() {
        lookUpRoutinesUseCaseInteractor.execute();
    }
}
