package app.edit_routine;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutinePresenter;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import use_case.rename_routine.RenameRoutineInputBoundary;
import use_case.rename_routine.RenameRoutineInteractor;
import use_case.rename_routine.RenameRoutineOutputBoundary;

public class RenameRoutineUseCaseFactory {

    private RenameRoutineUseCaseFactory() {}

    public static RenameRoutineView create(
            ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineRepViewModel,
            FileRoutineDataAccessObject routineDataAccessObject) {
        // TODO: Uncomment when data access has been written
//        try {
        RenameRoutineController renameRoutineController = createRenameRoutineRepUseCase(viewManagerModel, renameRoutineRepViewModel, routineDataAccessObject);
        return new RenameRoutineView(renameRoutineController, renameRoutineRepViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open routine data file.");
//        }
    }

    private static RenameRoutineController createRenameRoutineRepUseCase(ViewManagerModel viewManagerModel,
                                                                         RenameRoutineViewModel renameRoutineRepViewModel,
                                                                         FileRoutineDataAccessObject routineDataAccessObject) {
        RenameRoutineOutputBoundary renameRoutineOutputBoundary = new RenameRoutinePresenter(viewManagerModel, renameRoutineRepViewModel);

        RenameRoutineInputBoundary renameInteractor = new RenameRoutineInteractor(routineDataAccessObject, renameRoutineOutputBoundary);

        return new RenameRoutineController(renameInteractor);
    }
}
