package app;

import data_access.RoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.lookup_routine.LookUpRoutineViewModel;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.LookUpRoutineView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

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

        LookUpRoutineViewModel lookUpRoutineViewModel = new LookUpRoutineViewModel();
        AdjustSetRepViewModel adjustSetRepViewModel = new AdjustSetRepViewModel();
        RenameRoutineViewModel renameRoutineViewModel = new RenameRoutineViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();
        DeleteExerciseViewModel deleteExerciseViewModel = new DeleteExerciseViewModel();

        RoutineDataAccessObject routineDataAccessObject;
        routineDataAccessObject = new RoutineDataAccessObject();

        LookUpRoutineView lookUpRoutineView = LookUpRoutineViewUseCaseFactory.create(viewManagerModel, lookUpRoutineViewModel, renameRoutineViewModel,
                addExerciseViewModel, deleteExerciseViewModel, adjustSetRepViewModel, routineDataAccessObject);
        views.add(lookUpRoutineView, lookUpRoutineView.viewName);

        viewManagerModel.setActiveView(lookUpRoutineView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

}