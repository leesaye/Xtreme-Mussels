package interface_adapter.reorder_routine;

import use_case.reorder_routine.ReorderRoutineOutputBoundary;
import use_case.reorder_routine.ReorderRoutineOutputData;

public class ReorderRoutinePresenter implements ReorderRoutineOutputBoundary {

    private final ReorderRoutineViewModel reorderRoutineViewModel;

    public ReorderRoutinePresenter(ReorderRoutineViewModel reorderRoutineViewModel, ReorderRoutineViewModel reorderRoutineViewModel1) {
        this.reorderRoutineViewModel = reorderRoutineViewModel1;
    }

    @Override
    public void prepareSuccessView(ReorderRoutineOutputData data) {
        ReorderRoutineState editState = reorderRoutineViewModel.getState();
        editState.setRoutineName(data.getName());
        reorderRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ReorderRoutineState editState = reorderRoutineViewModel.getState();
        editState.setRoutineNameError(error);
        reorderRoutineViewModel.firePropertyChanged();
    }
}
