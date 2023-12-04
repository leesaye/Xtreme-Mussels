package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;
import view.GenerateRoutineView;
import view.LookUpRoutinesView;
import view.LookupView;
import view.MainView;

import javax.swing.*;
import java.io.IOException;

public class MainUseCaseFactory {
    private MainUseCaseFactory() {}

    public static MainView create(ViewManagerModel viewManagerModel, MainViewModel mainViewModel, LookUpRoutinesViewModel lookUpRoutinesViewModel, LookupView lookupView, LookUpRoutinesView lookUpRoutinesView, RoutineDataAccessObject routineDataAccessObject) {
        try {
            LookUpRoutinesController lookUpRoutinesController = LookUpRoutinesUseCaseFactory.createLookUpRoutinesCase(viewManagerModel, lookUpRoutinesViewModel, routineDataAccessObject);

            return new MainView(mainViewModel, viewManagerModel, lookupView, lookUpRoutinesView, lookUpRoutinesController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not");

        }

        return null;
    }
}
