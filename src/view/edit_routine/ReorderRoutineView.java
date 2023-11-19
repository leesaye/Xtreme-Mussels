package view.edit_routine;

import interface_adapter.reorder_routine.ReorderRoutineController;
import interface_adapter.reorder_routine.ReorderRoutineState;
import interface_adapter.reorder_routine.ReorderRoutineViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReorderRoutineView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "reorder";

    private final ReorderRoutineViewModel reorderViewModel;

    private final ReorderRoutineController reorderController;

    private final JButton save;

    private final JButton cancel;


    public ReorderRoutineView(ReorderRoutineController controller, ReorderRoutineViewModel reorderRoutineViewModel) {

        this.reorderController = controller;
        this.reorderViewModel = reorderRoutineViewModel;
        reorderViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ReorderRoutineViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: create a list of exercises which can be moved around, then a listener to update State with new order

        JPanel buttons = new JPanel();
        save = new JButton(ReorderRoutineViewModel.SAVE_BUTTON_LABEL);
        cancel = new JButton(ReorderRoutineViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(save);
        buttons.add(cancel);

        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(save)) {
                            ReorderRoutineState currentState = ReorderRoutineViewModel.getState();

                            reorderController.execute(currentState.getId(), currentState.getExercises());
                        }

                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // TODO: implement this - cancel goes back to the routine view
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
