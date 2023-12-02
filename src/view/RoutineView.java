package view;

import interface_adapter.add_exercise.AddExerciseController;
import interface_adapter.add_exercise.AddExerciseViewModel;
import interface_adapter.adjust_setrep.AdjustSetRepController;
import interface_adapter.adjust_setrep.AdjustSetRepState;
import interface_adapter.adjust_setrep.AdjustSetRepViewModel;
import interface_adapter.delete_exercise.DeleteExerciseController;
import interface_adapter.delete_exercise.DeleteExerciseViewModel;
import interface_adapter.rename_routine.RenameRoutineController;
import interface_adapter.rename_routine.RenameRoutineViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RoutineView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "single routine";

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

    public RoutineView(RenameRoutineController renameRoutineController, RenameRoutineViewModel renameRoutineViewModel,
                       AddExerciseController addExerciseController, AddExerciseViewModel addExerciseViewModel,
                       DeleteExerciseController deleteExerciseController, DeleteExerciseViewModel deleteExerciseViewModel,
                       AdjustSetRepController adjustSetRepController, AdjustSetRepViewModel adjustSetRepViewModel) {
        this.renameRoutineController = renameRoutineController;
        this.renameRoutineViewModel = renameRoutineViewModel;

        this.addExerciseController = addExerciseController;
        this.addExerciseViewModel = addExerciseViewModel;

        this.deleteExerciseController = deleteExerciseController;
        this.deleteExerciseViewModel = deleteExerciseViewModel;

        this.adjustSetRepController = adjustSetRepController;
        this.adjustSetRepViewModel = adjustSetRepViewModel;

        JLabel title = new JLabel("Routine");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        table = new JTable();
        JScrollPane tableScrlPane = new JScrollPane(table);

        JPanel buttons = new JPanel();
        add = new JButton(AddExerciseViewModel.ADD_BUTTON_LABEL);
        delete = new JButton(DeleteExerciseViewModel.DELETE_BUTTON_LABEL);
        rename = new JButton(RenameRoutineViewModel.RENAME_BUTTON_LABEL);
        adjust = new JButton(AdjustSetRepViewModel.ADJUST_BUTTON_LABEL);
        buttons.add(add);
        buttons.add(delete);
        buttons.add(rename);
        buttons.add(adjust);

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        rename.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        adjust.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

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
