package app.edit_routine;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutinePresenter;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import use_case.rename_routine.RenameRoutineInputBoundary;
import use_case.rename_routine.RenameRoutineInteractor;
import use_case.rename_routine.RenameRoutineOutputBoundary;

public class RenameRoutineUseCaseFactory {

    private RenameRoutineUseCaseFactory() {}

    public static RenameRoutineController createRenameRoutineRepUseCase(ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineRepViewModel,
                                                                         RoutineDataAccessObject routineDataAccessObject) {
        RenameRoutineOutputBoundary renameRoutineOutputBoundary = new RenameRoutinePresenter(viewManagerModel, renameRoutineRepViewModel);

        RenameRoutineInputBoundary renameInteractor = new RenameRoutineInteractor(routineDataAccessObject, renameRoutineOutputBoundary);

        return new RenameRoutineController(renameInteractor);
    }
}
