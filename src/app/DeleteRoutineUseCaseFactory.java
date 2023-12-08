package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_routine.DeleteRoutineController;
import interface_adapter.delete_routine.DeleteRoutinePresenter;
import interface_adapter.delete_routine.DeleteRoutineViewModel;
import use_case.delete_routine.DeleteRoutineInputBoundary;
import use_case.delete_routine.DeleteRoutineInteractor;
import use_case.delete_routine.DeleteRoutineOutputBoundary;


public class DeleteRoutineUseCaseFactory {
    private DeleteRoutineUseCaseFactory() {}

    public static DeleteRoutineController createDeleteRoutineUseCase(ViewManagerModel viewManagerModel, DeleteRoutineViewModel deleteRoutineViewModel, RoutineDataAccessObject routineDataAccessObject) {
        DeleteRoutineOutputBoundary deleteRoutineOutputBoundary = new DeleteRoutinePresenter(viewManagerModel, deleteRoutineViewModel);

        DeleteRoutineInputBoundary deleteRoutineInteractor = new DeleteRoutineInteractor(routineDataAccessObject, deleteRoutineOutputBoundary);

        return new DeleteRoutineController(deleteRoutineInteractor);
    }
}
