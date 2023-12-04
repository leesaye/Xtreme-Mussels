package app;

import app.edit_routine.AdjustSetRepUseCaseFactory;
import data_access.ExerciseDataAccessObject;
import data_access.RoutineDataAccessObject;
import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.generate_routine.GenerateRoutineViewModel;
import interface_adapter.lookup.LookUpViewModel;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class Main {
    public static void main(String[] args) {

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

        AdjustSetRepViewModel adjustSetRepViewModel = new AdjustSetRepViewModel();
        RenameRoutineViewModel renameRoutineViewModel = new RenameRoutineViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();
        DeleteExerciseViewModel deleteExerciseViewModel = new DeleteExerciseViewModel();
        MainViewModel mainViewModel = new MainViewModel("Xtreme Mussels");
        LookUpViewModel lookUpViewModel = new LookUpViewModel("Look Up Exercise");
        ExerciseDataAccessObject exerciseDataAccessObject = new ExerciseDataAccessObject();

        GenerateRoutineViewModel generateRoutineViewModel = new GenerateRoutineViewModel() {
            @Override
            public void firePropertyChange() {

            }
        };
        RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

        // TODO: uncomment the try/catch block when DAO has been written
//        RoutineDataAccessObject routineDataAccessObject;
//        try {
//            routineDataAccessObject = new RoutineDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        RoutineView routineView = RoutineViewUseCaseFactory.create(viewManagerModel, renameRoutineViewModel,
//                addExerciseViewModel, deleteExerciseViewModel, routineDataAccessObject);
//        views.add(routineView, routineView.viewName);

//        AdjustSetRepView adjustView = AdjustSetRepUseCaseFactory.create(viewManagerModel, adjustSetRepViewModel, routineDataAccessObject);
//        views.add(adjustView, adjustView.viewName);
//
//        viewManagerModel.setActiveView(adjustView.viewName);
        LookupView lookupView = LookUpUseCaseFactory.create(viewManagerModel, lookUpViewModel, exerciseDataAccessObject);
        views.add(lookupView, lookupView.lookUpViewName);

        GenerateRoutineView generateRoutineView = GenerateRoutineUseCaseFactory.create(viewManagerModel, generateRoutineViewModel, routineDataAccessObject);
        views.add(generateRoutineView, generateRoutineView.generateRoutineViewName);

        MainView mainView = new MainView(mainViewModel, viewManagerModel, lookupView, new LookUpRoutinesView());
        views.add(mainView, mainView.mainViewName);

        viewManagerModel.setActiveView(mainView.mainViewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

}