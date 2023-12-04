package view;

import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.lookup.LookUpViewModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String mainViewName = "Xtreme Mussels Main View";
    private final JButton lookUpExercises;
    private final JButton viewAllRoutines;
    private final MainViewModel mainViewModel;
    private ViewManagerModel viewManagerModel;
    private LookupView lookupView;
    private LookUpRoutinesView lookUpRoutinesView;
    private LookUpRoutinesController lookUpRoutinesController;


    public MainView(MainViewModel mainViewModel, ViewManagerModel viewManagerModel, LookupView lookupView, LookUpRoutinesView lookUpRoutinesView, LookUpRoutinesController controller){
        this.mainViewModel = mainViewModel;
        this.viewManagerModel = viewManagerModel;
        this.lookupView = lookupView;
        this.lookUpRoutinesView = lookUpRoutinesView;
        this.lookUpRoutinesController = controller;

        mainViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(MainViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        lookUpExercises = new JButton(MainViewModel.LOOKUP_LABEL);
        viewAllRoutines = new JButton(MainViewModel.VIEWALL_LABEL);
        JPanel buttons = new JPanel();
        buttons.add(lookUpExercises);
        buttons.add(viewAllRoutines);

        lookUpExercises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(lookUpExercises)) {

                    //TODO: just add the view name
                    viewManagerModel.setActiveView(lookupView.lookUpViewName);
                    viewManagerModel.firePropertyChanged();
                }
            }
        });

        viewAllRoutines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(viewAllRoutines)) {
                    // call the controller for lookUpRoutines

                    System.out.println("works?");
                    //TODO: uncomment once lookupRoutines is done
                    lookUpRoutinesController.execute();
                    viewManagerModel.setActiveView(lookUpRoutinesView.lookUpRoutinesName);
                    viewManagerModel.firePropertyChanged();



                }
            }
        });

        this.setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
