package view;

import javax.swing.*;

public class LabelComboPanel extends JPanel {


    /**
     * A panel containing a label and a combo Box.
     */

        LabelComboPanel(JLabel label, JComboBox comboBox) {
            this.add(label);
            this.add(comboBox);

    }

}
