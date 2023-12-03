package view;

import interface_adapter.lookup.LookUpController;
import interface_adapter.lookup.LookUpState;
import interface_adapter.lookup.LookUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LookupView extends JPanel implements ActionListener, PropertyChangeListener {
    // adding the field to enter the name for lookUp
    private final JTextField lookupByName = new JTextField(20);
    private final JComboBox lookupByTarget;

    private final JButton lookUpByNameButton;
    private final JButton lookUpByTargetButton;
    // adding the controller and view model
    private final LookUpViewModel lookUpViewModel;
    private final LookUpController controller;

    public LookupView(LookUpViewModel lookUpViewModel, LookUpController controller) {
        this.lookUpViewModel = lookUpViewModel;
        this.controller = controller;
        lookUpViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(LookUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] items = {"abductors" ,"abs","adductors","biceps","calves","cardiovascular system","delts","forearms","glutes","hamstrings","lats","levator scapulae","pectorals","quads","serratus anterior","spine","traps","triceps","upper back"};
        lookupByTarget = new JComboBox<>(items);
        JPanel buttons = new JPanel();
        lookUpByNameButton = new JButton(LookUpViewModel.NAME_LOOKUP_BUTTON_LABEL);
        lookUpByTargetButton = new JButton(LookUpViewModel.TARGET_LOOKUP_BUTTON_LABEL);
        LabelComboPanel byTarget = new LabelComboPanel(new JLabel(LookUpViewModel.TARGET_LOOKUP_BUTTON_LABEL), lookupByTarget);
        LabelTextPanel byName = new LabelTextPanel(new JLabel(LookUpViewModel.NAME_LOOKUP_BUTTON_LABEL), lookupByName);
        buttons.add(lookUpByNameButton);
        buttons.add(lookUpByTargetButton);

        // the lookUpByName actionlistener:
        lookUpByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(lookUpByNameButton)) {
                    LookUpState currState = lookUpViewModel.getState();
                    controller.execute(lookupByName.getText(), "name");
                }
            }
        });

        lookUpByTargetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(lookUpByTargetButton)) {
                    LookUpState currState = lookUpViewModel.getState();
                    controller.execute((String) lookupByTarget.getSelectedItem(), "target");
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
