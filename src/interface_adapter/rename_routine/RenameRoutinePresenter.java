package interface_adapter.rename_routine;

import interface_adapter.ViewManagerModel;
import use_case.rename_routine.RenameRoutineOutputBoundary;
import use_case.rename_routine.RenameRoutineOutputData;

public class RenameRoutinePresenter implements RenameRoutineOutputBoundary {

    private final RenameRoutineViewModel renameRoutineViewModel;

    private ViewManagerModel viewManagerModel;

    public RenameRoutinePresenter(ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.renameRoutineViewModel = renameRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(RenameRoutineOutputData data) {
        RenameRoutineState renameRoutineState = renameRoutineViewModel.getState();
        renameRoutineState.setName(data.getName());
        renameRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        RenameRoutineState renameRoutineState = renameRoutineViewModel.getState();
        renameRoutineState.setName(error);
        renameRoutineViewModel.firePropertyChanged();
    }
}
