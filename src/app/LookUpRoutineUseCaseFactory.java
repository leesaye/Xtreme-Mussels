package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.lookup_routine.LookUpRoutineController;
import interface_adapter.lookup_routine.LookUpRoutineViewModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import use_case.lookup_routine.LookUpRoutineInputBoundary;
import use_case.lookup_routine.LookUpRoutineInteractor;
import use_case.lookup_routine.LookUpRoutineOutputBoundary;
import interface_adapter.lookup_routine.LookUpRoutinePresenter;
import view.LookUpRoutineView;

import java.io.IOException;

import static app.LookUpRoutinesUseCaseFactory.createLookUpRoutinesCase;
import static app.edit_routine.AddExerciseUseCaseFactory.createAddExerciseUseCase;
import static app.edit_routine.AdjustSetRepUseCaseFactory.createAdjustSetRepUseCase;
import static app.edit_routine.DeleteExerciseUseCaseFactory.createDeleteExerciseUseCase;
import static app.edit_routine.RenameRoutineUseCaseFactory.createRenameRoutineRepUseCase;

public class LookUpRoutineUseCaseFactory {

    private LookUpRoutineUseCaseFactory() {}

    public static LookUpRoutineView create(
            ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel, LookUpRoutinesViewModel lookUpRoutinesViewModel,
            RenameRoutineViewModel renameRoutineRepViewModel, AddExerciseViewModel addExerciseViewModel,
            DeleteExerciseViewModel deleteExerciseViewModel, AdjustSetRepViewModel adjustViewModel, RoutineDataAccessObject routineDataAccessObject) throws IOException {

        LookUpRoutinesController lookUpRoutinesController = createLookUpRoutinesCase(viewManagerModel, lookUpRoutinesViewModel, routineDataAccessObject);

        RenameRoutineController renameRoutineController = createRenameRoutineRepUseCase(viewManagerModel, renameRoutineRepViewModel, routineDataAccessObject);
        AddExerciseController addExerciseController = createAddExerciseUseCase(viewManagerModel, addExerciseViewModel, routineDataAccessObject);
        DeleteExerciseController deleteExerciseController = createDeleteExerciseUseCase(viewManagerModel, deleteExerciseViewModel, routineDataAccessObject);
        AdjustSetRepController adjustSetRepController = createAdjustSetRepUseCase(viewManagerModel, adjustViewModel, routineDataAccessObject);

        return new LookUpRoutineView(lookUpRoutineViewModel, lookUpRoutinesController,renameRoutineController, renameRoutineRepViewModel, addExerciseController, addExerciseViewModel,
                deleteExerciseController, deleteExerciseViewModel, adjustSetRepController, adjustViewModel, viewManagerModel);
    }

    // May not need these create use case methods, keeping them here just in case

    public static LookUpRoutineController createLookUpRoutineUseCase(ViewManagerModel viewManagerModel, LookUpRoutineViewModel lookUpRoutineViewModel, RoutineDataAccessObject routineDataAccessObject) {
        LookUpRoutineOutputBoundary presenter = new LookUpRoutinePresenter(viewManagerModel, lookUpRoutineViewModel);

        LookUpRoutineInputBoundary interactor = new LookUpRoutineInteractor(routineDataAccessObject, presenter);

        return new LookUpRoutineController(interactor);
    }

}
