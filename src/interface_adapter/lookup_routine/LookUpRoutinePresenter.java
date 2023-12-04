package interface_adapter.lookup_routine;

import interface_adapter.ViewManagerModel;
import use_case.lookup_routine.LookUpRoutineOutputBoundary;
import use_case.lookup_routine.LookUpRoutineOutputData;

public class LookUpRoutinePresenter implements LookUpRoutineOutputBoundary {
    private final LookUpRoutineViewModel lookUpRoutineViewModel;
    private ViewManagerModel viewManagerModel;

    public LookUpRoutinePresenter(ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.lookUpRoutineViewModel = lookUpRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(LookUpRoutineOutputData response) {
        LookUpRoutineState lookUpRoutineState = lookUpRoutineViewModel.getState();
        lookUpRoutineState.setRoutine(response.getRoutine());
        lookUpRoutineState.setExercisesDisplay();
        lookUpRoutineViewModel.setState(lookUpRoutineState);
        this.lookUpRoutineViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("single routine");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LookUpRoutineState lookUpRoutineState = lookUpRoutineViewModel.getState();
        lookUpRoutineState.setRoutineError(error);
        lookUpRoutineViewModel.setState(lookUpRoutineState);
        lookUpRoutineViewModel.firePropertyChanged();
    }
}
