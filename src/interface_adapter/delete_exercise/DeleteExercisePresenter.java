package interface_adapter.delete_exercise;

import interface_adapter.ViewManagerModel;
import interface_adapter.delete_exercise.DeleteExerciseState;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import use_case.delete_exercise.DeleteExerciseOutputBoundary;
import use_case.delete_exercise.DeleteExerciseOutputData;

public class DeleteExercisePresenter implements DeleteExerciseOutputBoundary {
    private final DeleteExerciseViewModel deleteExerciseViewModel;

    private ViewManagerModel viewManagerModel;

    public DeleteExercisePresenter(ViewManagerModel viewManagerModel, DeleteExerciseViewModel deleteExerciseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.deleteExerciseViewModel = deleteExerciseViewModel;
    }

    @Override
    public void prepareSuccessView(DeleteExerciseOutputData data) {
        DeleteExerciseState deleteExerciseState = deleteExerciseViewModel.getState();
        deleteExerciseState.setName(data.getRoutineName());
        deleteExerciseState.setRoutine(data.getRoutine());
        deleteExerciseState.setExercisesDisplay();
        deleteExerciseViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteExerciseState deleteExerciseState = deleteExerciseViewModel.getState();
        deleteExerciseState.deleteExerciseNameError(error);
        deleteExerciseViewModel.firePropertyChanged();
    }

}
