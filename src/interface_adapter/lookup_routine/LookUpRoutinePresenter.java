package interface_adapter.lookup_routine;

import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup.LookUpOutputData;

public class LookUpRoutinePresenter implements LookUpOutputBoundary {
    private final LookUpRoutineViewModel lookUpRoutineViewModel;
    private ViewManagerModel viewManagerModel;

    public LookUpRoutinePresenter(ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.lookUpRoutineViewModel = lookUpRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(LookUpOutputData response) {
        LookUpRoutineState lookUpRoutineState = lookUpRoutineViewModel.getState();
        // TODO
        this.lookUpRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LookUpRoutineState lookUpRoutineState = lookUpRoutineViewModel.getState();
        lookUpRoutineState.setExercisesError(error);
        lookUpRoutineViewModel.firePropertyChanged();
    }
}
