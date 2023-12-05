package view;


import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_routine.AddRoutineController;
import interface_adapter.lookup_routine.LookUpRoutineController;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesState;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import use_case.lookup_routine.LookUpRoutineInteractor;
//import app.AddRoutineUseCaseFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class LookUpRoutinesView extends JPanel implements ActionListener, PropertyChangeListener {

    private JTable table;
    public final String lookUpRoutinesName = "All Routines";
    //Table Model
    private static DefaultTableModel model;
    private final JButton add;
    private final JButton cancel;
    private final JButton generateWorkoutButton;
    private final LookUpRoutinesController lookUpRoutinesController;
    private final LookUpRoutinesViewModel lookUpRoutinesViewModel;
    private ViewManagerModel viewManagerModel;
    private LookupView lookupView;
    private GenerateRoutineView generateRoutineView;
    // Add Routine button
    private LookUpRoutineController lookUpRoutineController;
    private AddRoutineController addRoutineController;
    public LookUpRoutinesView(LookUpRoutinesViewModel lookUpRoutinesViewModel,
                              LookUpRoutinesController lookUpRoutinesController,
                              ViewManagerModel viewManagerModel, GenerateRoutineView generateRoutineView,
                              LookUpRoutineController lookUpRoutineController
//           , AddRoutineController addRoutineController
    ) {
        this.lookUpRoutinesViewModel = lookUpRoutinesViewModel;
        this.lookUpRoutinesController = lookUpRoutinesController;
        this.viewManagerModel = viewManagerModel;
        this.generateRoutineView = generateRoutineView;
        this.lookUpRoutineController = lookUpRoutineController;
        this.addRoutineController = addRoutineController;
        JLabel title = new JLabel(LookUpRoutinesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LookUpRoutinesState currState = lookUpRoutinesViewModel.getState();

       model = new DefaultTableModel(new String[0][],LookUpRoutinesViewModel.COLUMN_HEADERS)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.getTableHeader().setReorderingAllowed(false);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (col == 0) {
                    String routineName = (String) table.getValueAt(row, col);
                    lookUpRoutineController.execute(routineName);
                }

            }
        });
        JPanel buttons = new JPanel();
        add = new JButton(LookUpRoutinesViewModel.ADD_BUTTON_LABEL);
        cancel = new JButton(LookUpRoutinesViewModel.CANCEL_BUTTON_LABEL);
        generateWorkoutButton = new JButton(LookUpRoutinesViewModel.GENERATE_BUTTON_LABEL);

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(add)) {
                            String newName = JOptionPane.showInputDialog("Enter a new routine name: ");
                            addRoutineController.execute(newName);

                        }
                    }
                }
        );

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(cancel)) {
                    viewManagerModel.setActiveView("Xtreme Mussels Main View");
                    viewManagerModel.firePropertyChanged();

                }
            }
        });

        generateWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(generateWorkoutButton)) {
                    System.out.println("pressed");
                    viewManagerModel.setActiveView(generateRoutineView.generateRoutineViewName);
                    viewManagerModel.firePropertyChanged();

                }
            }
        });
        buttons.add(add);
        buttons.add(generateWorkoutButton);
        buttons.add(cancel);
        lookUpRoutinesViewModel.addPropertyChangeListener(this);



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(tableScrollPane);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        model = new DefaultTableModel(lookUpRoutinesViewModel.getState().getRoutinesDisplay(), LookUpRoutinesViewModel.COLUMN_HEADERS) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        table.setModel(model);
    }
}

