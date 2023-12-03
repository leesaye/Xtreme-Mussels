package view;

import interface_adapter.generate_routine.GenerateRoutineController;
import interface_adapter.generate_routine.GenerateRoutineState;
import interface_adapter.generate_routine.GenerateRoutineViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GenerateWorkoutView extends JPanel implements ActionListener, PropertyChangeListener {

    //adding all the text fields for target, name and number of exercises required by the user
    private final JTextField targetBodyPartField = new JTextField(20);
    private final JTextField numberofExercisesField = new JTextField(5);
    private final JTextField nameOfRoutineField = new JTextField(50);

    private final GenerateRoutineController controller;
    private final GenerateRoutineViewModel generateRoutineViewModel;

    private final JButton generateRoutine;

    public GenerateWorkoutView(GenerateRoutineController controller, GenerateRoutineViewModel generateRoutineViewModel) {
        this.controller = controller;
        this.generateRoutineViewModel = generateRoutineViewModel;
        generateRoutineViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GenerateRoutineViewModel.VIEW_NAME);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        generateRoutine = new JButton(GenerateRoutineViewModel.GENERATE_ROUTINE_LABEL);
        buttons.add(generateRoutine);
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
                            controller.execute(currState.getTargetBody(), currState.getNumberOfExercises(), currState.getRoutineName());
                        }
                    }
                }
        );

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
        if (evt.getPropertyName().equals("state")) {
            GenerateRoutineState state = (GenerateRoutineState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, "Routine is successfully created!");
        }
    }

    // for testing purposes:
//    public static void main(String[] args) {
//
//
//        JLabel title = new JLabel(GenerateRoutineViewModel.VIEW_NAME);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        JPanel buttons = new JPanel();
//        JButton generateRoutine = new JButton(GenerateRoutineViewModel.GENERATE_ROUTINE_LABEL);
//        buttons.add(generateRoutine);
//        JTextField targetBodyPartField = new JTextField(15);
//        JTextField numberofExercisesField = new JTextField(5);
//        JTextField nameOfRoutineField = new JTextField(15);
//        LabelTextPanel routineNameInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.ROUTINE_NAME), nameOfRoutineField);
//        LabelTextPanel targetInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.TARGET_LABEL), targetBodyPartField);
//        LabelTextPanel numberOfExercisesInfo = new LabelTextPanel(new JLabel(GenerateRoutineViewModel.NUMBER_EXERCISES_LABEL), numberofExercisesField);
//
//        generateRoutine.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (e.getSource().equals(generateRoutine)) {
//                            System.out.println("button pressed!");
//                            System.out.println(nameOfRoutineField.getText());
//                            System.out.println(numberofExercisesField.getText());
//                            System.out.println(targetBodyPartField.getText());
//
//                        }
//                    }
//                }
//        );
//        JFrame application = new JFrame("Generate Routine");
//        application.setLayout(new BoxLayout(application.getContentPane(), BoxLayout.Y_AXIS));
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        application.add(title);
//        application.add(routineNameInfo);
//        application.add(targetInfo);
//        application.add(numberOfExercisesInfo);
//        application.add(buttons);
//
//        // Adjust the size of the JFrame to fit the components
//        application.pack();
//
//        // Center the JFrame on the screen
//
//        // Make the JFrame visible
//        application.setVisible(true);
//    }


}
