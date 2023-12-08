package interface_adapter.delete_routine;

import interface_adapter.ViewManagerModel;
import use_case.delete_routine.DeleteRoutineOutputBoundary;
import use_case.delete_routine.DeleteRoutineOutputData;

public class DeleteRoutinePresenter implements DeleteRoutineOutputBoundary {

    private final DeleteRoutineViewModel deleteRoutineViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteRoutinePresenter(ViewManagerModel viewManagerModel, DeleteRoutineViewModel deleteRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.deleteRoutineViewModel = deleteRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(DeleteRoutineOutputData data) {
        DeleteRoutineState deleteRoutineState = deleteRoutineViewModel.getState();
        deleteRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteRoutineState deleteRoutineState = deleteRoutineViewModel.getState();
        deleteRoutineState.deleteRoutineNameError(error);
        deleteRoutineViewModel.firePropertyChanged();

    }
}
