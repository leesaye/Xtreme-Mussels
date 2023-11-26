package view;

import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.edit_routine.AddExerciseView;

import javax.swing.*;

public class RoutineView extends JPanel {

    public final String viewName = "routines";

    private final RenameRoutineViewModel renameRoutineViewModel;

    private final RenameRoutineController renameRoutineController;

    private final AddExerciseViewModel addExerciseViewModel;

    private final AddExerciseController addExerciseController;

    private final DeleteExerciseViewModel deleteExerciseViewModel;

    private final DeleteExerciseController deleteExerciseController;

    public RoutineView(RenameRoutineController renameRoutineController, RenameRoutineViewModel renameRoutineViewModel,
                       AddExerciseController addExerciseController, AddExerciseViewModel addExerciseViewModel,
                       DeleteExerciseController deleteExerciseController, DeleteExerciseViewModel deleteExerciseViewModel) {
        this.renameRoutineController = renameRoutineController;
        this.renameRoutineViewModel = renameRoutineViewModel;

        this.addExerciseController = addExerciseController;
        this.addExerciseViewModel = addExerciseViewModel;

        this.deleteExerciseController = deleteExerciseController;
        this.deleteExerciseViewModel = deleteExerciseViewModel;
    }
}
