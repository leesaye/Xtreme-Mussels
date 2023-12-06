package view;

import entity.Routine;
import interface_adapter.ViewManagerModel;
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

    private final ViewManagerModel viewManagerModel;

    private final JLabel title;

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
                             AdjustSetRepController adjustSetRepController, AdjustSetRepViewModel adjustSetRepViewModel,
                             ViewManagerModel viewManagerModel) {

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

        this.viewManagerModel = viewManagerModel;

        lookUpRoutineViewModel.addPropertyChangeListener(this);
        renameRoutineViewModel.addPropertyChangeListener(this);
        addExerciseViewModel.addPropertyChangeListener(this);
        deleteExerciseViewModel.addPropertyChangeListener(this);
        adjustSetRepViewModel.addPropertyChangeListener(this);



        title = new JLabel(LookUpRoutineViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        model = new DefaultTableModel(lookUpRoutineViewModel.getState().getExercisesDisplay(), LookUpRoutineViewModel.COLUMN_HEADERS);
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
                            if (newExercise != null && !newExercise.isEmpty()) { // User entered info and clicked OK
                                Routine routine = lookUpRoutineViewModel.getState().getRoutine();
                                addExerciseController.execute(routine.getRoutineName(), newExercise);
                            } else if (newExercise != null) { // User did not cancel, but did not enter any information
                                JOptionPane.showMessageDialog(null, "Please enter an exercise");
                            }
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
                            if (newName != null && !newName.isEmpty()) { // User did not click cancel and entered text
                                renameRoutineController.execute(routine.getRoutineName(), newName);
                            } else if (newName != null) { // User did not click cancel and did not enter any text
                                JOptionPane.showMessageDialog(null, "Please enter a name");
                            }
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
                        viewManagerModel.setActiveView("All Routines");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        this.add(title);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(tableScrlPane);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof AddExerciseState) {
            AddExerciseState state = (AddExerciseState) evt.getNewValue();
            if (state.getUseCaseSuccess()) {// Exercise added successfully
            model = new DefaultTableModel(addExerciseViewModel.getState().getExercisesDisplay(), LookUpRoutineViewModel.COLUMN_HEADERS);
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "Added " + state.getName());
            } else{
                JOptionPane.showMessageDialog(this, state.getRoutineNameError());
            }
        }

        else if (evt.getNewValue() instanceof DeleteExerciseState) {
            model = new DefaultTableModel(deleteExerciseViewModel.getState().getExercisesDisplay(), LookUpRoutineViewModel.COLUMN_HEADERS);
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "Exercise deleted");
        }

        else if (evt.getNewValue() instanceof RenameRoutineState) {
            RenameRoutineState state = (RenameRoutineState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, "Routine renamed to " + state.getName());
            title.setText(state.getName() + " view");
        }

        else if (evt.getNewValue() instanceof AdjustSetRepState) {
            model = new DefaultTableModel(adjustSetRepViewModel.getState().getExercisesDisplay(), LookUpRoutineViewModel.COLUMN_HEADERS);
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "New sets and reps saved");
        }

        else { // The event was switching into the view
            model = new DefaultTableModel(lookUpRoutineViewModel.getState().getExercisesDisplay(), LookUpRoutineViewModel.COLUMN_HEADERS);
            table.setModel(model);
            title.setText(lookUpRoutineViewModel.getState().getRoutine().getRoutineName() + " view");
        }
    }

}
