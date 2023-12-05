package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.lookup.LookUpPresenter;
import interface_adapter.lookup_routine.LookUpRoutineController;
import interface_adapter.lookup_routine.LookUpRoutineViewModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesPresenter;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import use_case.lookup.LookUpDataAccessInterface;
import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;
import use_case.lookup_routines.LookUpRoutinesInputBoundary;
import use_case.lookup_routines.LookUpRoutinesInteractor;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import app.LookUpRoutineUseCaseFactory;
import view.GenerateRoutineView;
import view.LookUpRoutinesView;
import view.MainView;

import javax.swing.*;
import java.io.IOException;

import static app.LookUpRoutineUseCaseFactory.createLookUpRoutineUseCase;

public class LookUpRoutinesUseCaseFactory {
    private LookUpRoutinesUseCaseFactory() {}

    public static LookUpRoutinesView create(ViewManagerModel viewManagerModel, LookUpRoutinesViewModel lookUpRoutinesViewModel, RoutineDataAccessObject routineDataAccessObject, GenerateRoutineView generateRoutineView, LookUpRoutineViewModel lookUpRoutineViewModel) {
        try {
            LookUpRoutinesController lookUpRoutinesController = createLookUpRoutinesCase(viewManagerModel, lookUpRoutinesViewModel, routineDataAccessObject);
            LookUpRoutineController lookUpRoutineController = createLookUpRoutineUseCase(viewManagerModel, lookUpRoutineViewModel, routineDataAccessObject);
            return new LookUpRoutinesView(lookUpRoutinesViewModel, lookUpRoutinesController, viewManagerModel, generateRoutineView, lookUpRoutineController);


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

