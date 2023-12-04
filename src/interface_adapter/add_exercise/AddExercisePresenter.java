package interface_adapter.add_exercise;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseState;
import interface_adapter.add_exercise.AddExerciseViewModel;
import use_case.add_exercise.AddExerciseOutputBoundary;
import use_case.add_exercise.AddExerciseOutputData;

public class AddExercisePresenter implements AddExerciseOutputBoundary {
    private final AddExerciseViewModel addExerciseViewModel;

    private ViewManagerModel viewManagerModel;

    public AddExercisePresenter(ViewManagerModel viewManagerModel, AddExerciseViewModel addExerciseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addExerciseViewModel = addExerciseViewModel;
    }

    @Override
    public void prepareSuccessView(AddExerciseOutputData data) {
        AddExerciseState addExerciseState = addExerciseViewModel.getState();
        addExerciseState.setRoutineName(data.getRoutineName());
        addExerciseState.setRoutine(data.getRoutine());
        addExerciseState.setExercisesDisplay();
        addExerciseViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddExerciseState addExerciseState = addExerciseViewModel.getState();
        addExerciseState.addExerciseNameError(error);
        addExerciseViewModel.firePropertyChanged();
    }

}
