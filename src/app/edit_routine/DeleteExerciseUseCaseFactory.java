package app.edit_routine;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExercisePresenter;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import use_case.delete_exercise.DeleteExerciseInputBoundary;
import use_case.delete_exercise.DeleteExerciseInteractor;
import use_case.delete_exercise.DeleteExerciseOutputBoundary;

public class DeleteExerciseUseCaseFactory {
    private DeleteExerciseUseCaseFactory() {}

    public static DeleteExerciseController createDeleteExerciseUseCase(ViewManagerModel viewManagerModel, DeleteExerciseViewModel deleteExerciseViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        DeleteExerciseOutputBoundary deleteExerciseOutputBoundary = new DeleteExercisePresenter(viewManagerModel, deleteExerciseViewModel);

        DeleteExerciseInputBoundary deleteExerciseInteractor = new DeleteExerciseInteractor(routineDataAccessObject, deleteExerciseOutputBoundary);

        return new DeleteExerciseController(deleteExerciseInteractor);
    }
}
