package interface_adapter.lookup_routine;

import interface_adapter.ViewManagerModel;
import use_case.lookup_routine.LookUpRoutineOutputData;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import use_case.lookup_routines.LookUpRoutinesOutputData;

public class LookUpRoutinesPresenter implements LookUpRoutinesOutputBoundary {
    private final LookUpRoutinesViewModel lookUpRoutinesViewModel;
    private ViewManagerModel viewManagerModel;

    public LookUpRoutinesPresenter(ViewManagerModel viewManagerModel, LookUpRoutinesViewModel lookUpRoutinesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.lookUpRoutinesViewModel = lookUpRoutinesViewModel;
    }

    @Override
    public void prepareSuccessView(LookUpRoutinesOutputData response) {
        LookUpRoutinesState lookUpRoutineState = lookUpRoutinesViewModel.getState();
//        lookUpRoutineState.setRoutine(response.getRoutine());
//        lookUpRoutineState.setExercisesDisplay(response.getRoutine());
        lookUpRoutinesViewModel.setState(lookUpRoutineState);
        this.lookUpRoutinesViewModel.firePropertyChanged();
    }
}
