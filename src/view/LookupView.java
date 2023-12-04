package view;

import app.LookUpRoutinesUseCaseFactory;
import com.sun.tools.javac.Main;
import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.lookup.LookUpController;
import interface_adapter.lookup.LookUpState;
import interface_adapter.lookup.LookUpViewModel;
import interface_adapter.lookup_routines.LookUpRoutinesController;
import interface_adapter.lookup_routines.LookUpRoutinesViewModel;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;
import use_case.lookup_routines.LookUpRoutinesInputBoundary;
import use_case.lookup_routines.LookUpRoutinesInteractor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LookupView extends JPanel implements ActionListener, PropertyChangeListener {
    // adding the field to enter the name for lookUp
    public final String lookUpViewName = "Look Up Exervises";
    private final JTextField lookupByName = new JTextField(20);
    private final JComboBox lookupByTarget;

    private final JButton lookUpByNameButton;
    private final JButton lookUpByTargetButton;
    private final JButton cancelButton;
    // adding the controller and view model
    private final LookUpViewModel lookUpViewModel;
    private final LookUpController controller;

    private ViewManagerModel viewManagerModel;
    private LookUpRoutinesView lookUpRoutinesView;
    public LookupView(LookUpViewModel lookUpViewModel, LookUpController controller, ViewManagerModel viewManagerModel) {
        this.lookUpViewModel = lookUpViewModel;
        this.controller = controller;
        this.viewManagerModel = viewManagerModel;
//        MainView mainView = new MainView(new MainViewModel(""), viewManagerModel, LookupView.this, lookUpRoutinesView);
//        this.mainView = mainView;
        lookUpViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(LookUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] items = {"abductors" ,"abs","adductors","biceps","calves","cardiovascular system","delts","forearms","glutes","hamstrings","lats","levator scapulae","pectorals","quads","serratus anterior","spine","traps","triceps","upper back"};
        lookupByTarget = new JComboBox<>(items);
        JPanel buttons = new JPanel();
        cancelButton = new JButton(LookUpViewModel.CANCEL_BUTTON_LABEL);
        lookUpByNameButton = new JButton(LookUpViewModel.NAME_LOOKUP_BUTTON_LABEL);
        lookUpByTargetButton = new JButton(LookUpViewModel.TARGET_LOOKUP_BUTTON_LABEL);
        LabelComboPanel byTarget = new LabelComboPanel(new JLabel(LookUpViewModel.TARGET_LOOKUP_BUTTON_LABEL), lookupByTarget);
        LabelTextPanel byName = new LabelTextPanel(new JLabel(LookUpViewModel.NAME_LOOKUP_BUTTON_LABEL), lookupByName);
        buttons.add(lookUpByNameButton);
        buttons.add(lookUpByTargetButton);
        buttons.add(cancelButton);

        // the lookUpByName actionlistener:
        lookUpByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(lookUpByNameButton)) {
                    LookUpState currState = lookUpViewModel.getState();
                    controller.execute(lookupByName.getText(), "name");
                    String[][] output = lookUpViewModel.getState().getExercisesDisplay();
                    DefaultTableModel model = new DefaultTableModel(new String[0][], new String[]{"Exercise Name", "Target Area/Muscle"})

                    {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    for (String[] row : output) {
                        String routineName = row[0];
                        String exercises = row[1];

                        // Add a new row to the model
                        model.addRow(new Object[]{routineName, exercises});
                    }


                    JTable table = new JTable(model);
                    JScrollPane tableScrollPane = new JScrollPane(table);
                    table.getTableHeader().setReorderingAllowed(false);


                    JOptionPane.showMessageDialog(LookupView.this, tableScrollPane, "Exercise Lookup Result", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        lookUpByTargetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(lookUpByTargetButton)) {
                    LookUpState currState = lookUpViewModel.getState();
                    controller.execute((String) lookupByTarget.getSelectedItem(), "target");
                    String[][] output = lookUpViewModel.getState().getExercisesDisplay();
                    DefaultTableModel model = new DefaultTableModel(new String[0][], new String[]{"Exercise Name", "Target Area/Muscle"})

                    {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    for (String[] row : output) {
                        String routineName = row[0];
                        String exercises = row[1];

                        // Add a new row to the model
                        model.addRow(new Object[]{routineName, exercises});
                    }


                    JTable table = new JTable(model);
                    JScrollPane tableScrollPane = new JScrollPane(table);
                    table.getTableHeader().setReorderingAllowed(false);


                    JOptionPane.showMessageDialog(LookupView.this, tableScrollPane, "Exercise Lookup Result", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(cancelButton)) {
                    viewManagerModel.setActiveView("Xtreme Mussels Main View");
                    viewManagerModel.firePropertyChanged();

                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(byName);
        this.add(byTarget);
        this.add(buttons);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
