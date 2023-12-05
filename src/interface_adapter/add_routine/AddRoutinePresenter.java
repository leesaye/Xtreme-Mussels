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
        this.addExerciseViewModel = addExerciseViewModel;
    }


    @Override
    public void prepareSuccessView(AddRoutineOutputData response) {
//        On success, switch to the <add exercise> view.
//        TODO: uncomment and modify once AddExercise interface adapter is done / merged
//        AddExerciseState addExerciseState = addExerciseViewModel.getState();
//        addExerciseState.setRoutineName(response.getRoutineName());
//        this.addExerciseViewModel.setState(addExerciseState);
//        addExerciseViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(addExerciseViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String error) {
        //        TODO: uncomment and modify once AddExercise interface adapter is done / merged
        //        AddRoutineState addRoutineState = addRoutineViewModel.getState();
        //        addRoutineState.setRoutineNameError(error);
        //        addRoutineViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
