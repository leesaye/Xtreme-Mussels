package app.edit_routine;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExercisePresenter;
import interface_adapter.add_exercise.AddExerciseViewModel;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInteractor;
import use_case.add_exercise.AddExerciseOutputBoundary;

public class AddExerciseUseCaseFactory {
    private AddExerciseUseCaseFactory() {}
    public static AddExerciseController createAddExerciseUseCase(ViewManagerModel viewManagerModel, AddExerciseViewModel addExerciseViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        AddExerciseOutputBoundary addExerciseOutputBoundary = new AddExercisePresenter(viewManagerModel, addExerciseViewModel);

        AddExerciseInputBoundary addExerciseInteractor = new AddExerciseInteractor(routineDataAccessObject, addExerciseOutputBoundary);

        return new AddExerciseController(addExerciseInteractor);
    }
}
