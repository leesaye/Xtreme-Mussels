package view;

import entity.Exercise;
import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate_routine.GenerateRoutineController;
import interface_adapter.generate_routine.GenerateRoutinePresenter;
import interface_adapter.generate_routine.GenerateRoutineState;
import interface_adapter.generate_routine.GenerateRoutineViewModel;
import use_case.generate_routine.GenerateRoutineInteractor;
import use_case.generate_routine.GenerateRoutineOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class GenerateRoutineView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String generateRoutineViewName = "Generate new routine";
    //adding all the text fields for target, name and number of exercises required by the user
    private final JTextField targetBodyPartField = new JTextField(20);
    private final JTextField numberofExercisesField = new JTextField(5);
    private final JTextField nameOfRoutineField = new JTextField(50);

    private final GenerateRoutineController controller;
    private final GenerateRoutineViewModel generateRoutineViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JButton generateRoutine;
    private final JButton cancelButton;
    private LookUpRoutinesView lookUpRoutinesView;
    private LookupView lookupView;


    public GenerateRoutineView(GenerateRoutineController controller, GenerateRoutineViewModel generateRoutineViewModel, ViewManagerModel viewManagerModel) {
        this.controller = controller;
        this.generateRoutineViewModel = generateRoutineViewModel;
        this.viewManagerModel = viewManagerModel;


        generateRoutineViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GenerateRoutineViewModel.VIEW_NAME);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        generateRoutine = new JButton(GenerateRoutineViewModel.GENERATE_ROUTINE_LABEL);
        cancelButton = new JButton(GenerateRoutineViewModel.BACK_TO_MAIN);
        buttons.add(generateRoutine);
        buttons.add(cancelButton);
        LabelTextPanel routineNameInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.ROUTINE_NAME), nameOfRoutineField);
        LabelTextPanel targetInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.TARGET_LABEL), targetBodyPartField);
        LabelTextPanel numberOfExercisesInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.NUMBER_EXERCISES_LABEL), numberofExercisesField);

        generateRoutine.addActionListener(
                //TODO: need to test this!
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generateRoutine)) {
                            GenerateRoutineState currState = generateRoutineViewModel.getGenerateRoutineState();
                            String numberOfExercisesText = numberofExercisesField.getText();
                            int numberofExercises = Integer.parseInt(numberOfExercisesText);
                            controller.execute(targetBodyPartField.getText(),numberofExercises, nameOfRoutineField.getText());
                            System.out.println(generateRoutineViewModel.getGenerateRoutineState().getRoutineList());
//                            ArrayList<Exercise> output = generateRoutineViewModel.getGenerateRoutineState().getRoutineList();
//                            StringBuilder namesString = new StringBuilder();
//                            for (Exercise exercise : output) {
//                                namesString.append(exercise.getName()).append(", ");
//                            }
//                            if (namesString.length() > 0) {
//                                namesString.delete(namesString.length() - 2, namesString.length());
//                            }
//                            String resultString = namesString.toString();
                            JOptionPane.showMessageDialog(GenerateRoutineView.this, "Routine named " + nameOfRoutineField.getText() + " created!");
                        }
                    }
                }
        );

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancelButton)) {
                    viewManagerModel.setActiveView("Xtreme Mussels Main View");
                    viewManagerModel.firePropertyChanged();

                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(routineNameInfo);
        this.add(targetInfo);
        this.add(numberOfExercisesInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //TODO: check this w everyone
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
