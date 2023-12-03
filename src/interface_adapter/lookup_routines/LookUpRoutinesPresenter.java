package interface_adapter.lookup_routines;

import interface_adapter.ViewManagerModel;
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
        LookUpRoutinesState lookUpRoutinesState = lookUpRoutinesViewModel.getState();
        lookUpRoutinesState.setRoutines(response.getAllRoutines());
        lookUpRoutinesState.setRoutinesDisplay(response.getAllRoutines());
        lookUpRoutinesViewModel.setState(lookUpRoutinesState);
        this.lookUpRoutinesViewModel.firePropertyChanged();
    }
}
