package use_case.lookup_routines;

public class LookUpRoutinesInteractor implements LookUpRoutinesInputBoundary {
    final LookUpRoutinesDataAccessInterface routineDataAccessObject;
    final LookUpRoutinesOutputBoundary routinePresenter;

    public LookUpRoutinesInteractor(LookUpRoutinesDataAccessInterface routineDataAccessObject, LookUpRoutinesOutputBoundary routinePresenter) {
        this.routineDataAccessObject = routineDataAccessObject;
        this.routinePresenter = routinePresenter;
    }

    @Override
    public void execute() {
        routineDataAccessObject.getRoutines();
        LookUpRoutinesOutputData lookUpRoutinesOutputData = new LookUpRoutinesOutputData(routineDataAccessObject.getRoutines());
        routinePresenter.prepareSuccessView(lookUpRoutinesOutputData);
    }
}
