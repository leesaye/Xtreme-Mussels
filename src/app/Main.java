package app;

import app.edit_routine.AdjustSetRepUseCaseFactory;
import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.rename_routine.RenameRoutineViewModel;
import view.RoutineView;
import view.ViewManager;
import view.edit_routine.AdjustSetRepView;

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

        AdjustSetRepViewModel adjustSetRepViewModel = new AdjustSetRepViewModel();
        RenameRoutineViewModel renameRoutineViewModel = new RenameRoutineViewModel();
        AddExerciseViewModel addExerciseViewModel = new AddExerciseViewModel();
        DeleteExerciseViewModel deleteExerciseViewModel = new DeleteExerciseViewModel();

        // TODO: uncomment the try/catch block when DAO has been written
        FileRoutineDataAccessObject routineDataAccessObject;
//        try {
            routineDataAccessObject = new FileRoutineDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        RoutineView routineView = RoutineViewUseCaseFactory.create(viewManagerModel, renameRoutineViewModel,
                addExerciseViewModel, deleteExerciseViewModel, adjustSetRepViewModel, routineDataAccessObject);
        views.add(routineView, routineView.viewName);

//        AdjustSetRepView adjustView = AdjustSetRepUseCaseFactory.create(viewManagerModel, adjustSetRepViewModel, routineDataAccessObject);
//        views.add(adjustView, adjustView.viewName);

        viewManagerModel.setActiveView(routineView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

}