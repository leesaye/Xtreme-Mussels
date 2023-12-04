package interface_adapter.add_routine;


import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseState;
import interface_adapter.add_exercise.AddExerciseViewModel;
import use_case.add_routine.AddRoutineOutputBoundary;
import use_case.add_routine.AddRoutineOutputData;


public class AddRoutinePresenter implements AddRoutineOutputBoundary {
    private final AddRoutineViewModel addRoutineViewModel;
    private ViewManagerModel viewManagerModel;
    private AddExerciseViewModel addExerciseViewModel;


    public AddRoutinePresenter(ViewManagerModel viewManagerModel, AddRoutineViewModel addRoutineViewModel, AddExerciseViewModel addExerciseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addRoutineViewModel = addRoutineViewModel;
    }


    @Override
    public void prepareSuccessView(AddRoutineOutputData response) {
//      On success, switch to the <Single Routine> view.
//      TODO: modify once everything is merged

//        Template:
//        AddExerciseState addExerciseState = addExerciseViewModel.getState();
//        addExerciseState.setRoutineName(response.getRoutineName());
//        this.addExerciseViewModel.setState(addExerciseState);
//        addExerciseViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(addExerciseViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String error) {
//      TODO: modify once everything is merged
        AddRoutineState addRoutineState = addRoutineViewModel.getState();
        addRoutineState.setRoutineNameError(error);
        addRoutineViewModel.firePropertyChanged();
    }
}
