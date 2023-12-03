package use_case.lookup_routine;

public class LookUpRoutineInteractor implements LookUpRoutineInputBoundary {
    final LookUpRoutineDataAccessInterface routineDataAccessObject;
    final LookUpRoutineOutputBoundary routinePresenter;

    public LookUpRoutineInteractor(LookUpRoutineDataAccessInterface routineDataAccessObject, LookUpRoutineOutputBoundary routinePresenter) {
        this.routineDataAccessObject = routineDataAccessObject;
        this.routinePresenter = routinePresenter;
    }

    @Override
    public void execute(LookUpRoutineInputData lookUpRoutineInputData) {
        if (!routineDataAccessObject.existsByName(lookUpRoutineInputData.getRoutineName())) {
            routinePresenter.prepareFailView("Invalid routine name.");
        } else {
            routineDataAccessObject.getRoutine(lookUpRoutineInputData.getRoutineName());
            LookUpRoutineOutputData lookUpRoutineOutputData = new LookUpRoutineOutputData(routineDataAccessObject.getRoutine(lookUpRoutineInputData.getRoutineName()), false);
            routinePresenter.prepareSuccessView(lookUpRoutineOutputData);
        }
    }
}
