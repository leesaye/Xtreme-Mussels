package app;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExercisePresenter;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExercisePresenter;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutinePresenter;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInteractor;
import use_case.add_exercise.AddExerciseOutputBoundary;
import use_case.delete_exercise.DeleteExerciseInputBoundary;
import use_case.delete_exercise.DeleteExerciseInteractor;
import use_case.delete_exercise.DeleteExerciseOutputBoundary;
import use_case.rename_routine.RenameRoutineInputBoundary;
import use_case.rename_routine.RenameRoutineInteractor;
import use_case.rename_routine.RenameRoutineOutputBoundary;
import view.RoutineView;

public class RoutineViewUseCaseFactory {

    private RoutineViewUseCaseFactory() {}

    public static RoutineView create(
            ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineRepViewModel, AddExerciseViewModel addExerciseViewModel,
            DeleteExerciseViewModel deleteExerciseViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        // TODO: Uncomment when data access has been written
//        try {
        RenameRoutineController renameRoutineController = createRenameRoutineRepUseCase(viewManagerModel, renameRoutineRepViewModel, routineDataAccessObject);
        AddExerciseController addExerciseController = createAddExerciseUseCase(viewManagerModel, addExerciseViewModel, routineDataAccessObject);
        DeleteExerciseController deleteExerciseController = createDeleteExerciseUseCase(viewManagerModel, deleteExerciseViewModel, routineDataAccessObject);
        return new RoutineView(renameRoutineController, renameRoutineRepViewModel, addExerciseController, addExerciseViewModel, deleteExerciseController, deleteExerciseViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open routine data file.");
//        }
    }

    private static DeleteExerciseController createDeleteExerciseUseCase(ViewManagerModel viewManagerModel, DeleteExerciseViewModel deleteExerciseViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        DeleteExerciseOutputBoundary deleteExerciseOutputBoundary = new DeleteExercisePresenter(viewManagerModel, deleteExerciseViewModel);

        DeleteExerciseInputBoundary deleteExerciseInteractor= new DeleteExerciseInteractor(routineDataAccessObject, deleteExerciseOutputBoundary);

        return new DeleteExerciseController(deleteExerciseInteractor);
    }

    private static AddExerciseController createAddExerciseUseCase(ViewManagerModel viewManagerModel, AddExerciseViewModel addExerciseViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        AddExerciseOutputBoundary addExerciseOutputBoundary = new AddExercisePresenter(viewManagerModel, addExerciseViewModel);

        AddExerciseInputBoundary addExerciseInteractor = new AddExerciseInteractor(routineDataAccessObject, addExerciseOutputBoundary);

        return new AddExerciseController(addExerciseInteractor);
    }

    private static RenameRoutineController createRenameRoutineRepUseCase(ViewManagerModel viewManagerModel,
                                                                         RenameRoutineViewModel renameRoutineRepViewModel,
                                                                         FileRoutineDataAccessObject routineDataAccessObject) {
        RenameRoutineOutputBoundary renameRoutineOutputBoundary = new RenameRoutinePresenter(viewManagerModel, renameRoutineRepViewModel);

        RenameRoutineInputBoundary renameInteractor = new RenameRoutineInteractor(routineDataAccessObject, renameRoutineOutputBoundary);

        return new RenameRoutineController(renameInteractor);
    }
}
