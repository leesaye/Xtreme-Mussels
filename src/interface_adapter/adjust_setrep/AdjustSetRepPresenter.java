package interface_adapter.adjust_setrep;

import interface_adapter.ViewManagerModel;
import use_case.adjust_setrep.AdjustSetRepOutputBoundary;
import use_case.adjust_setrep.AdjustSetRepOutputData;

public class AdjustSetRepPresenter implements AdjustSetRepOutputBoundary {

    private final AdjustSetRepViewModel adjustSetRepViewModel;

    private ViewManagerModel viewManagerModel;

    public AdjustSetRepPresenter(ViewManagerModel viewManagerModel, AdjustSetRepViewModel adjustSetRepViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.adjustSetRepViewModel = adjustSetRepViewModel;
    }

    @Override
    public void prepareSuccessView(AdjustSetRepOutputData data) {
        AdjustSetRepState adjustState = adjustSetRepViewModel.getState();
        adjustState.setRoutineName(data.getName());
        adjustSetRepViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AdjustSetRepState adjustState = adjustSetRepViewModel.getState();
        adjustState.setRoutineNameError(error);
        adjustSetRepViewModel.firePropertyChanged();
    }
}
