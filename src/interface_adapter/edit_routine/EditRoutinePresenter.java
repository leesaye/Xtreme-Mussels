package interface_adapter.edit_routine;

import use_case.edit_routine.EditRoutineOutputBoundary;
import use_case.edit_routine.EditRoutineOutputData;

public class EditRoutinePresenter implements EditRoutineOutputBoundary {

    private final EditRoutineViewModel editRoutineViewModel;

    public EditRoutinePresenter(EditRoutineViewModel editRoutineViewModel, EditRoutineViewModel editRoutineViewModel1) {
        this.editRoutineViewModel = editRoutineViewModel1;
    }

    @Override
    public void prepareSuccessView(EditRoutineOutputData data) {
        EditRoutineState editState = editRoutineViewModel.getState();
        editState.setRoutineName(data.getName());
        editRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        EditRoutineState editState = editRoutineViewModel.getState();
        editState.setRoutineNameError(error);
        editRoutineViewModel.firePropertyChanged();
    }
}
