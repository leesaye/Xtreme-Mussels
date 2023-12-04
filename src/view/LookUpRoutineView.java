package view;

import entity.Routine;
import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseState;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepState;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseState;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.lookup_routine.LookUpRoutineViewModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineState;
import interface_adapter.rename_routine.RenameRoutineViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class LookUpRoutineView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "single routine";

    private final LookUpRoutineViewModel lookUpRoutineViewModel;

    private final LookUpRoutinesController lookUpRoutinesController;

    private final RenameRoutineViewModel renameRoutineViewModel;

    private final RenameRoutineController renameRoutineController;

    private final AddExerciseViewModel addExerciseViewModel;

    private final AddExerciseController addExerciseController;

    private final DeleteExerciseViewModel deleteExerciseViewModel;

    private final DeleteExerciseController deleteExerciseController;

    private final AdjustSetRepViewModel adjustSetRepViewModel;

    private final AdjustSetRepController adjustSetRepController;

    private final JButton add;

    private final JButton delete;

    private final JButton rename;

    private final JButton adjust;

    private final JTable table;

    private static DefaultTableModel model;

    private final JButton back;

    public LookUpRoutineView(LookUpRoutineViewModel lookUpRoutineViewModel, LookUpRoutinesController lookUpRoutinesController,
                             RenameRoutineController renameRoutineController, RenameRoutineViewModel renameRoutineViewModel,
                             AddExerciseController addExerciseController, AddExerciseViewModel addExerciseViewModel,
                             DeleteExerciseController deleteExerciseController, DeleteExerciseViewModel deleteExerciseViewModel,
                             AdjustSetRepController adjustSetRepController, AdjustSetRepViewModel adjustSetRepViewModel) {

        this.lookUpRoutineViewModel = lookUpRoutineViewModel;
        this.lookUpRoutinesController = lookUpRoutinesController;

        this.renameRoutineController = renameRoutineController;
        this.renameRoutineViewModel = renameRoutineViewModel;

        this.addExerciseController = addExerciseController;
        this.addExerciseViewModel = addExerciseViewModel;

        this.deleteExerciseController = deleteExerciseController;
        this.deleteExerciseViewModel = deleteExerciseViewModel;

        this.adjustSetRepController = adjustSetRepController;
        this.adjustSetRepViewModel = adjustSetRepViewModel;

        lookUpRoutineViewModel.addPropertyChangeListener(this);
        renameRoutineViewModel.addPropertyChangeListener(this);
        addExerciseViewModel.addPropertyChangeListener(this);
        deleteExerciseViewModel.addPropertyChangeListener(this);
        adjustSetRepViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(LookUpRoutineViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        model = new DefaultTableModel(lookUpRoutineViewModel.getState().getExercisesDisplay(), AdjustSetRepViewModel.COLUMN_HEADERS);
        table = new JTable(model);
        JScrollPane tableScrlPane = new JScrollPane(table);

        JPanel buttons = new JPanel();
        add = new JButton(AddExerciseViewModel.ADD_BUTTON_LABEL);
        delete = new JButton(DeleteExerciseViewModel.DELETE_BUTTON_LABEL);
        rename = new JButton(RenameRoutineViewModel.RENAME_BUTTON_LABEL);
        adjust = new JButton(AdjustSetRepViewModel.ADJUST_BUTTON_LABEL);
        back = new JButton(LookUpRoutineViewModel.BACK_BUTTON_LABEL);
        buttons.add(add);
        buttons.add(delete);
        buttons.add(rename);
        buttons.add(adjust);
        buttons.add(back);

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(add)) {
                            String newExercise = JOptionPane.showInputDialog(("Enter a new exercise:"));
                            Routine routine = lookUpRoutineViewModel.getState().getRoutine();
                            addExerciseController.execute(routine.getRoutineName(), newExercise);
                        }
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(delete)) {
                            if (table.getSelectedRow() != -1) {
                                Routine routine = lookUpRoutineViewModel.getState().getRoutine();
                                String exerciseName = table.getValueAt(table.getSelectedRow(), 0).toString();
                                deleteExerciseController.execute(routine.getRoutineName(), exerciseName);
                            } else {
                                JOptionPane.showMessageDialog(null, "Select a row and try again");
                            }
                        }
                    }
                }
        );

        rename.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(rename)) {
                            Routine routine = lookUpRoutineViewModel.getState().getRoutine();
                            String newName = JOptionPane.showInputDialog("Enter a new routine name: ");
                            renameRoutineController.execute(routine.getRoutineName(), newName);
                        }
                    }
                }
        );

        adjust.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(adjust)) {
                            Routine routine = lookUpRoutineViewModel.getState().getRoutine();

                            // Create ArrayLists of integers for the controller
                            ArrayList<Integer> sets = new ArrayList<>();
                            ArrayList<Integer> reps = new ArrayList<>();

                            for(int i = 0; i < model.getRowCount(); i++) {
                                sets.add(parseInt(model.getValueAt(i, 1).toString()));
                                reps.add(parseInt(model.getValueAt(i, 2).toString()));
                            }

                            adjustSetRepController.execute(routine.getRoutineName(), sets, reps);
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lookUpRoutinesController.execute();
                    }
                }
        );

        this.add(title);
        this.add(tableScrlPane);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Button not implemented yet");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof AddExerciseState) {
            model = new DefaultTableModel(addExerciseViewModel.getState().getExercisesDisplay(), AdjustSetRepViewModel.COLUMN_HEADERS);
            JOptionPane.showMessageDialog(this, "Exercise added");
        }

        else if (evt.getNewValue() instanceof DeleteExerciseState) {
            model = new DefaultTableModel(deleteExerciseViewModel.getState().getExercisesDisplay(), AdjustSetRepViewModel.COLUMN_HEADERS);
            JOptionPane.showMessageDialog(this, "Exercise deleted");
        }

        else if (evt.getNewValue() instanceof RenameRoutineState) {
            RenameRoutineState state = (RenameRoutineState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, state.getName() + ": rename success");
        }

        else if (evt.getNewValue() instanceof AdjustSetRepState) {
            model = new DefaultTableModel(adjustSetRepViewModel.getState().getExercisesDisplay(), AdjustSetRepViewModel.COLUMN_HEADERS);
            JOptionPane.showMessageDialog(this, "New sets and reps saved");
        }

        else { // The event was switching into the view
            model = new DefaultTableModel(lookUpRoutineViewModel.getState().getExercisesDisplay(), AdjustSetRepViewModel.COLUMN_HEADERS);
        }

        table.setModel(model);
    }

}
