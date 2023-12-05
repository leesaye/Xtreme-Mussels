package interface_adapter.add_routine;

import interface_adapter.ViewManagerModel;
import use_case.add_routine.AddRoutineOutputBoundary;
import use_case.add_routine.AddRoutineOutputData;


public class AddRoutinePresenter implements AddRoutineOutputBoundary {
    private final AddRoutineViewModel addRoutineViewModel;
    private ViewManagerModel viewManagerModel;

    public AddRoutinePresenter(ViewManagerModel viewManagerModel, AddRoutineViewModel addRoutineViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addRoutineViewModel = addRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(AddRoutineOutputData response) {

        // On success, switch to the <Single Routine> view.

        AddRoutineState addRoutineState = addRoutineViewModel.getState();
        addRoutineState.setRoutineName(response.getRoutineName());
        addRoutineState.setExercisesDisplay();
        addRoutineViewModel.setState(addRoutineState);
        this.addRoutineViewModel.firePropertyChanged();

        viewManagerModel.setActiveView("single routine");
        viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        AddRoutineState addRoutineState = addRoutineViewModel.getState();
        addRoutineState.setRoutineNameError(error);
        addRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
