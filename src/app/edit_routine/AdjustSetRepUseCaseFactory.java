package app.edit_routine;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepPresenter;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import use_case.adjust_setrep.AdjustSetRepInputBoundary;
import use_case.adjust_setrep.AdjustSetRepInteractor;
import use_case.adjust_setrep.AdjustSetRepOutputBoundary;
import view.edit_routine.AdjustSetRepView;

public class AdjustSetRepUseCaseFactory {

    private AdjustSetRepUseCaseFactory() {}

    public static AdjustSetRepView create(
            ViewManagerModel viewManagerModel, AdjustSetRepViewModel adjustSetRepViewModel,
            RoutineDataAccessObject routineDataAccessObject) {
        // TODO: Uncomment when data access has been written
//        try {
            AdjustSetRepController adjustController = createAdjustSetRepUseCase(viewManagerModel, adjustSetRepViewModel, routineDataAccessObject);
            return new AdjustSetRepView(adjustController, adjustSetRepViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open routine data file.");
//        }
    }

    private static AdjustSetRepController createAdjustSetRepUseCase(ViewManagerModel viewManagerModel, AdjustSetRepViewModel adjustSetRepViewModel, RoutineDataAccessObject routineDataAccessObject) {
        AdjustSetRepOutputBoundary adjustOutputBoundary = new AdjustSetRepPresenter(viewManagerModel, adjustSetRepViewModel);

        AdjustSetRepInputBoundary adjustInteractor = new AdjustSetRepInteractor(routineDataAccessObject, adjustOutputBoundary);

        return new AdjustSetRepController(adjustInteractor);
    }

}
