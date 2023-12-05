package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesPresenter;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import use_case.lookup_routines.LookUpRoutinesInputBoundary;
import use_case.lookup_routines.LookUpRoutinesInteractor;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import view.LookUpRoutinesView;

public class LookUpRoutinesUseCaseFactory {
    private LookUpRoutinesUseCaseFactory() { }

    public static LookUpRoutinesView create() {
        // TODO: implement this use case factory!!!!
        return null;
    }

    public static LookUpRoutinesController createLookUpRoutinesUseCase(ViewManagerModel viewManagerModel, LookUpRoutinesViewModel lookUpRoutinesViewModel, RoutineDataAccessObject routineDataAccessObject) {
        LookUpRoutinesOutputBoundary presenter = new LookUpRoutinesPresenter(viewManagerModel, lookUpRoutinesViewModel);

        LookUpRoutinesInputBoundary interactor = new LookUpRoutinesInteractor(routineDataAccessObject, presenter);

        return new LookUpRoutinesController(interactor);
    }
}
