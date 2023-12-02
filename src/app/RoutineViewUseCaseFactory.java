package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.RoutineView;

import static app.edit_routine.AddExerciseUseCaseFactory.createAddExerciseUseCase;
import static app.edit_routine.AdjustSetRepUseCaseFactory.createAdjustSetRepUseCase;
import static app.edit_routine.DeleteExerciseUseCaseFactory.createDeleteExerciseUseCase;
import static app.edit_routine.RenameRoutineUseCaseFactory.createRenameRoutineRepUseCase;

public class RoutineViewUseCaseFactory {

    private RoutineViewUseCaseFactory() {}

    public static RoutineView create(
            ViewManagerModel viewManagerModel, RenameRoutineViewModel renameRoutineRepViewModel, AddExerciseViewModel addExerciseViewModel,
            DeleteExerciseViewModel deleteExerciseViewModel, AdjustSetRepViewModel adjustViewModel, RoutineDataAccessObject routineDataAccessObject) {
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
