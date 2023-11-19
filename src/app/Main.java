package app;

import data_access.FileRoutineDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.reorder_routine.ReorderRoutineViewModel;
import view.ViewManager;
import view.edit_routine.ReorderRoutineView;

import javax.swing.*;
import java.awt.*;
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

        ReorderRoutineViewModel reorderRoutineViewModel = new ReorderRoutineViewModel();

        // TODO: uncomment the try/catch block when DAO has been written
        FileRoutineDataAccessObject routineDataAccessObject;
//        try {
            routineDataAccessObject = new FileRoutineDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ReorderRoutineView reorderView = ReorderUseCaseFactory.create(viewManagerModel, reorderRoutineViewModel, routineDataAccessObject);
        views.add(reorderView, reorderView.viewName);

        viewManagerModel.setActiveView(reorderView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

}