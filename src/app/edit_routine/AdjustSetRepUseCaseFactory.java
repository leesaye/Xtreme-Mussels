package app.edit_routine;

import data_access.FileRoutineDataAccessObject;
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

    public static AdjustSetRepController createAdjustSetRepUseCase(ViewManagerModel viewManagerModel, AdjustSetRepViewModel adjustSetRepViewModel, FileRoutineDataAccessObject routineDataAccessObject) {
        AdjustSetRepOutputBoundary adjustOutputBoundary = new AdjustSetRepPresenter(viewManagerModel, adjustSetRepViewModel);

        AdjustSetRepInputBoundary adjustInteractor = new AdjustSetRepInteractor(routineDataAccessObject, adjustOutputBoundary);

        return new AdjustSetRepController(adjustInteractor);
    }

}
