package interface_adapter.reorder_routine;

import interface_adapter.ViewManagerModel;
import interface_adapter.reorder_routine.ReorderRoutineViewModel;
import use_case.reorder_routine.ReorderRoutineOutputBoundary;
import use_case.reorder_routine.ReorderRoutineOutputData;

public class ReorderRoutinePresenter implements ReorderRoutineOutputBoundary {

    private final ReorderRoutineViewModel reorderRoutineViewModel;

    private ViewManagerModel viewManagerModel;

    public ReorderRoutinePresenter(ViewManagerModel viewManagerModel, ReorderRoutineViewModel reorderRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.reorderRoutineViewModel = reorderRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(ReorderRoutineOutputData data) {
        ReorderRoutineState reorderState = reorderRoutineViewModel.getState();
        reorderState.setRoutineName(data.getName());
        reorderRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ReorderRoutineState reorderState = reorderRoutineViewModel.getState();
        reorderState.setRoutineNameError(error);
        reorderRoutineViewModel.firePropertyChanged();
    }
}
