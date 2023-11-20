package view.edit_routine;

import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepState;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AdjustSetRepView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "adjust";

    private final AdjustSetRepViewModel adjustViewModel;

    private final AdjustSetRepController adjustController;

    private final JButton save;

    private final JButton cancel;

    private final JTable table;

    public AdjustSetRepView(AdjustSetRepController controller, AdjustSetRepViewModel adjustSetRepViewModel) {

        this.adjustController = controller;
        this.adjustViewModel = adjustSetRepViewModel;
        adjustViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AdjustSetRepViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: create a list of exercises which can be moved around, then a listener to update State with new order
//        JTable exercises = new JTable(AdjustSetRepViewModel.getState().getExercisesReps(), AdjustSetRepViewModel.COLUMN_HEADERS);
        // TEMPORARY WHILE DAO HASN'T BEEN CREATED YET
        table = new JTable(new Object[][]{{"pullups", 52}, {"squats", 10}}, AdjustSetRepViewModel.COLUMN_HEADERS);

        JScrollPane tableScrlPane = new JScrollPane(table);

        JPanel buttons = new JPanel();
        save = new JButton(AdjustSetRepViewModel.SAVE_BUTTON_LABEL);
        cancel = new JButton(AdjustSetRepViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(save);
        buttons.add(cancel);

        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(save)) {
                            AdjustSetRepState currentState = AdjustSetRepViewModel.getState();

                            adjustController.execute(currentState.getId(), currentState.getExercises());
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
        this.add(tableScrlPane);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
