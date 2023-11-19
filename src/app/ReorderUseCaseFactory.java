package app;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.reorder_routine.ReorderRoutineController;
import interface_adapter.reorder_routine.ReorderRoutinePresenter;
import interface_adapter.reorder_routine.ReorderRoutineViewModel;
import use_case.reorder_routine.ReorderRoutineInputBoundary;
import use_case.reorder_routine.ReorderRoutineInteractor;
import use_case.reorder_routine.ReorderRoutineOutputBoundary;
import view.edit_routine.ReorderRoutineView;

import javax.swing.*;
import java.io.IOException;

public class ReorderUseCaseFactory {

    private ReorderUseCaseFactory() {}

    public static ReorderRoutineView create(
            ViewManagerModel viewManagerModel, ReorderRoutineViewModel reorderRoutineViewModel,
            FileRoutineDataAccessObject routineDataAccessObject) {
        // TODO: Uncomment when data access has been written
//        try {
            ReorderRoutineController reorderController = createReorderRoutineUseCase(viewManagerModel, reorderRoutineViewModel, routineDataAccessObject);
            return new ReorderRoutineView(reorderController, reorderRoutineViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open routine data file.");
//        }
    }

    private static ReorderRoutineController createReorderRoutineUseCase(ViewManagerModel viewManagerModel, ReorderRoutineViewModel reorderRoutineViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        ReorderRoutineOutputBoundary reorderOutputBoundary = new ReorderRoutinePresenter(viewManagerModel, reorderRoutineViewModel);

        ReorderRoutineInputBoundary reorderInteractor = new ReorderRoutineInteractor(routineDataAccessObject, reorderOutputBoundary);

        return new ReorderRoutineController(reorderInteractor);
    }

}
