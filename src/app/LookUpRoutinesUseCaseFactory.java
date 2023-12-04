package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.lookup.LookUpPresenter;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesPresenter;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import use_case.lookup.LookUpDataAccessInterface;
import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;
import use_case.lookup_routines.LookUpRoutinesInputBoundary;
import use_case.lookup_routines.LookUpRoutinesInteractor;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import view.GenerateRoutineView;
import view.LookUpRoutinesView;
import view.MainView;

import javax.swing.*;
import java.io.IOException;

public class LookUpRoutinesUseCaseFactory {
    private LookUpRoutinesUseCaseFactory() {}
    private MainView mainView;

    public static LookUpRoutinesView create(ViewManagerModel viewManagerModel, LookUpRoutinesViewModel lookUpRoutinesViewModel, LookUpRoutinesDataAccessInterface lookUpRoutinesDataAccessInterface, GenerateRoutineView generateRoutineView) {
        try {
            LookUpRoutinesController lookUpRoutinesController = createLookUpRoutinesCase(viewManagerModel, lookUpRoutinesViewModel, lookUpRoutinesDataAccessInterface);
            return new LookUpRoutinesView(lookUpRoutinesViewModel, lookUpRoutinesController, viewManagerModel, generateRoutineView);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not");

        }
        return null;
    }

    public static LookUpRoutinesController createLookUpRoutinesCase(
            ViewManagerModel viewManagerModel,
            LookUpRoutinesViewModel lookUpRoutinesViewModel,
            LookUpRoutinesDataAccessInterface lookUpRoutinesDataAccessInterface) throws IOException {
        LookUpRoutinesOutputBoundary lookUpRoutinesOutputBoundary = new LookUpRoutinesPresenter(viewManagerModel, lookUpRoutinesViewModel);
        LookUpRoutinesInputBoundary lookUpRoutinesInteractor = new LookUpRoutinesInteractor(
                lookUpRoutinesDataAccessInterface, lookUpRoutinesOutputBoundary);
        return new LookUpRoutinesController(lookUpRoutinesInteractor);
        }
    }


