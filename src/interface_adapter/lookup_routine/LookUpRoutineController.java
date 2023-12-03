package interface_adapter.lookup_routines;

import use_case.lookup_routine.LookUpRoutineInputBoundary;
import use_case.lookup_routine.LookUpRoutineInputData;

public class LookUpRoutineController {
    final LookUpRoutineInputBoundary lookUpRoutineUseCaseInteractor;
    
    public LookUpRoutineController(LookUpRoutineInputBoundary lookUpRoutineUseCaseInteractor) {
        this.lookUpRoutineUseCaseInteractor = lookUpRoutineUseCaseInteractor;
    }

    public void execute(String routineName) {
        LookUpRoutineInputData lookUpRoutineInputData = new LookUpRoutineInputData(routineName);
        lookUpRoutineUseCaseInteractor.execute(lookUpRoutineInputData);
    }
}
