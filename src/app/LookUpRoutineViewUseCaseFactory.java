package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.lookup_routine.LookUpRoutineViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.LookUpRoutineView;

import static app.edit_routine.AddExerciseUseCaseFactory.createAddExerciseUseCase;
import static app.edit_routine.AdjustSetRepUseCaseFactory.createAdjustSetRepUseCase;
import static app.edit_routine.DeleteExerciseUseCaseFactory.createDeleteExerciseUseCase;
import static app.edit_routine.RenameRoutineUseCaseFactory.createRenameRoutineRepUseCase;

public class LookUpRoutineViewUseCaseFactory {

    private LookUpRoutineViewUseCaseFactory() {}

    public static LookUpRoutineView create(
            ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel, RenameRoutineViewModel renameRoutineRepViewModel, AddExerciseViewModel addExerciseViewModel,
            DeleteExerciseViewModel deleteExerciseViewModel, AdjustSetRepViewModel adjustViewModel, RoutineDataAccessObject routineDataAccessObject) {

//        LookUpRoutineController controller = createLookUpRoutineUseCase(viewManagerModel, lookUpRoutineViewModel, routineDataAccessObject);

        RenameRoutineController renameRoutineController = createRenameRoutineRepUseCase(viewManagerModel, renameRoutineRepViewModel, routineDataAccessObject);
        AddExerciseController addExerciseController = createAddExerciseUseCase(viewManagerModel, addExerciseViewModel, routineDataAccessObject);
        DeleteExerciseController deleteExerciseController = createDeleteExerciseUseCase(viewManagerModel, deleteExerciseViewModel, routineDataAccessObject);
        AdjustSetRepController adjustSetRepController = createAdjustSetRepUseCase(viewManagerModel, adjustViewModel, routineDataAccessObject);

        return new LookUpRoutineView(lookUpRoutineViewModel, renameRoutineController, renameRoutineRepViewModel, addExerciseController, addExerciseViewModel,
                deleteExerciseController, deleteExerciseViewModel, adjustSetRepController, adjustViewModel);
    }

    // May not need these create use case methods, keeping them here just in case

//    private static LookUpRoutineController createLookUpRoutineUseCase(ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel, RoutineDataAccessObject routineDataAccessObject) {
//        LookUpRoutineOutputBoundary presenter = new LookUpRoutinePresenter(viewManagerModel, lookUpRoutineViewModel);
//
//        LookUpRoutineInputBoundary interactor = new LookUpRoutineInteractor(routineDataAccessObject, presenter);
//
//        return new LookUpRoutineController(interactor);
//    }

}
