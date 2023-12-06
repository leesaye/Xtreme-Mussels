package app;


import data_access.ExerciseDataAccessObject;
import data_access.RoutineDataAccessObject;
import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.add_routine.AddRoutineViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;

import interface_adapter.generate_routine.GenerateRoutineViewModel;
import interface_adapter.lookup.LookUpViewModel;

import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.*;

import interface_adapter.lookup_routine.LookUpRoutineViewModel;

import view.LookUpRoutineView;
import view.ViewManager;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class Main {
    public static void main(String[] args) throws IOException {

        // The main application window.
        JFrame application = new JFrame("Xtreme Mussels");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.

        LookUpRoutineViewModel lookUpRoutineViewModel = new LookUpRoutineViewModel();
        LookUpRoutinesViewModel lookUpRoutinesViewModel = new LookUpRoutinesViewModel();
        AdjustSetRepViewModel adjustSetRepViewModel = new AdjustSetRepViewModel();
        RenameRoutineViewModel renameRoutineViewModel = new RenameRoutineViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();
        DeleteExerciseViewModel deleteExerciseViewModel = new DeleteExerciseViewModel();
        AddRoutineViewModel addRoutineViewModel = new AddRoutineViewModel();
        MainViewModel mainViewModel = new MainViewModel("Xtreme Mussels");
        LookUpViewModel lookUpViewModel = new LookUpViewModel("Look Up Exercise");
        RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();
        routineDataAccessObject.setPath("RoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());

        ExerciseDataAccessObject exerciseDataAccessObject = new ExerciseDataAccessObject();
        GenerateRoutineViewModel generateRoutineViewModel = new GenerateRoutineViewModel() {
            @Override
            public void firePropertyChange() {

            }
        };
        LookUpRoutineView lookUpRoutineView = LookUpRoutineUseCaseFactory.create(viewManagerModel, lookUpRoutineViewModel,
                lookUpRoutinesViewModel, renameRoutineViewModel, addExerciseViewModel, deleteExerciseViewModel,
                adjustSetRepViewModel, routineDataAccessObject);
        views.add(lookUpRoutineView, lookUpRoutineView.viewName);

        GenerateRoutineView generateRoutineView = GenerateRoutineUseCaseFactory.create(viewManagerModel, generateRoutineViewModel, routineDataAccessObject);
        views.add(generateRoutineView, generateRoutineView.generateRoutineViewName);
        LookupView lookupView = LookUpUseCaseFactory.create(viewManagerModel, lookUpViewModel, exerciseDataAccessObject);
        views.add(lookupView, lookupView.lookUpViewName);

        LookUpRoutinesView lookUpRoutinesView = LookUpRoutinesUseCaseFactory.create(viewManagerModel, lookUpRoutinesViewModel, routineDataAccessObject, generateRoutineView, lookUpRoutineViewModel, addRoutineViewModel);
        views.add(lookUpRoutinesView, lookUpRoutinesView.lookUpRoutinesName);

        MainView mainView = MainUseCaseFactory.create(viewManagerModel, mainViewModel, lookUpRoutinesViewModel, lookupView, lookUpRoutinesView, routineDataAccessObject);
        views.add(mainView, mainView.mainViewName);

        viewManagerModel.setActiveView(lookupView.lookUpViewName);

        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

}