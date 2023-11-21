package view.edit_routine;

import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepState;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AdjustSetRepView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "adjust";

    private final AdjustSetRepViewModel adjustViewModel;

    private final AdjustSetRepController adjustController;

    private final JButton save;

    private final JButton cancel;

    private final JTable table;

    private static DefaultTableModel model;

    public AdjustSetRepView(AdjustSetRepController controller, AdjustSetRepViewModel adjustSetRepViewModel) {

        this.adjustController = controller;
        this.adjustViewModel = adjustSetRepViewModel;
        adjustViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(AdjustSetRepViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: create a list of exercises which can be moved around, then a listener to update State with new order
//        model = new DefaultTableModel(AdjustSetRepViewModel.getState().getSetReps(), AdjustSetRepViewModel.COLUMN_HEADERS);
        // TEMPORARY WHILE DAO HASN'T BEEN CREATED YET
        model = new DefaultTableModel(new Object[][]{{"pullups", 3, 10124}, {"squats", 342, 23125}}, AdjustSetRepViewModel.COLUMN_HEADERS);
        table = new JTable(model);
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

                            // Create ArrayLists of integers for the controller
                            ArrayList<Integer> sets = new ArrayList<>();
                            ArrayList<Integer> reps = new ArrayList<>();

                            for(int i = 0; i < model.getRowCount(); i++) {
                                sets.add(parseInt(model.getValueAt(i, 1).toString()));
                                reps.add(parseInt(model.getValueAt(i, 2).toString()));
                            }

                            adjustController.execute(currentState.getId(), sets, reps);
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
        // Show a popup saying save was successful
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
