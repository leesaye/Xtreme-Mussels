package view;

import interface_adapter.add_routine.AddRoutineController;
import interface_adapter.add_routine.AddRoutineState;
import interface_adapter.add_routine.AddRoutineViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddRoutineView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "add routine";
    private final JTextField routineNameInputField = new JTextField(15);
    private final JButton addRoutine;
    private final JButton cancel;
    private final AddRoutineViewModel addRoutineViewModel;
    private final AddRoutineController addRoutineController;

    public AddRoutineView(AddRoutineController addRoutineController, AddRoutineViewModel addRoutineViewModel) {

        this.addRoutineController = addRoutineController;
        this.addRoutineViewModel = addRoutineViewModel;
        addRoutineViewModel.addPropertyChangeListener(this);

        // Routines View Title
        JLabel title = new JLabel(AddRoutineViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // text input field to type routine name
        LabelTextPanel routineNameInfo = new LabelTextPanel(
                new JLabel(AddRoutineViewModel.ROUTINE_NAME_LABEL), routineNameInputField);

        // Buttons to either add after inputting routine name or cancel to go back
        JPanel buttons = new JPanel();
        addRoutine = new JButton(AddRoutineViewModel.Add_ROUTINE_BUTTON_LABEL);
        buttons.add(addRoutine);
        cancel = new JButton(AddRoutineViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        addRoutine.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addRoutine)) {
                            AddRoutineState currentState = addRoutineViewModel.getState();

                            addRoutineController.execute(
                                    currentState.getRoutineName()
                            );
                        }
                    }
                }
        );

        // TODO: do we want to implement a CANCEL button? simply switch back to the Routine View if clicked
        // cancel.addActionListener(this);

//        cancel.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(cancel)) {
//                        }
//                    }
//                }
//        );


        routineNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddRoutineState currentState = addRoutineViewModel.getState();
                        String text = routineNameInputField.getText() + e.getKeyChar();
                        currentState.setRoutineName(text);
                        addRoutineViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
                );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(routineNameInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddRoutineState state = (AddRoutineState) evt.getNewValue();
        if (state.getRoutineNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getRoutineNameError());
        }
        else {
            setFields(state);
        }
    }
    private void setFields(AddRoutineState state) {
        routineNameInputField.setText(state.getRoutineName());
    }
}
