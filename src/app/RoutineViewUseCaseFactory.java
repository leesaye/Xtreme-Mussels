package app;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExercisePresenter;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
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

import static app.edit_routine.AddExerciseUseCaseFactory.createAddExerciseUseCase;
import static app.edit_routine.AdjustSetRepUseCaseFactory.createAdjustSetRepUseCase;
import static app.edit_routine.DeleteExerciseUseCaseFactory.createDeleteExerciseUseCase;
import static app.edit_routine.RenameRoutineUseCaseFactory.createRenameRoutineRepUseCase;

public class RoutineViewUseCaseFactory {

    private RoutineViewUseCaseFactory() {}

    public static RoutineView create(
            ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineRepViewModel, AddExerciseViewModel addExerciseViewModel,
            DeleteExerciseViewModel deleteExerciseViewModel, AdjustSetRepViewModel adjustViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        // TODO: Uncomment when data access has been written
//        try {
        RenameRoutineController renameRoutineController = createRenameRoutineRepUseCase(viewManagerModel, renameRoutineRepViewModel, routineDataAccessObject);
        AddExerciseController addExerciseController = createAddExerciseUseCase(viewManagerModel, addExerciseViewModel, routineDataAccessObject);
        DeleteExerciseController deleteExerciseController = createDeleteExerciseUseCase(viewManagerModel, deleteExerciseViewModel, routineDataAccessObject);
        AdjustSetRepController adjustSetRepController = createAdjustSetRepUseCase(viewManagerModel, adjustViewModel, routineDataAccessObject);

        return new RoutineView(renameRoutineController, renameRoutineRepViewModel, addExerciseController, addExerciseViewModel,
                deleteExerciseController, deleteExerciseViewModel, adjustSetRepController, adjustViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open routine data file.");
//        }
    }


}
