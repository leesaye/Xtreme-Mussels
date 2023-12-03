package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LookUpRoutinesView extends JPanel implements ActionListener, PropertyChangeListener {

    private JTable table;
    //Table Model
    private static DefaultTableModel model;
    // Add Routine button

    public LookUpRoutinesView() {
        JLabel title = new JLabel("All Routines");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        model = new DefaultTableModel(new String[][]{{"routine 1", "arms", "bicep curls, tricep dips"}, {"routine 2", "arms", "bicep curls, tricep dips"}}, new String[]{"Routine Name", "Tagret", "Exercises"})
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
                    //TODO: need to link this to single workout view
                    String cellValue = (String) table.getValueAt(row, col);
                    System.out.println(cellValue);
                }

            }
        });
        JPanel buttons = new JPanel();
        JButton add = new JButton("Add");

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(add)) {
                            System.out.println("clicked");
                        }
                    }
                }
        );
        buttons.add(add);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(tableScrollPane);
        this.add(buttons);
    }

    // to test
    public static void main(String[] args) {

        JLabel title = new JLabel("All Routines");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JFrame application = new JFrame("Generate Routine");
        application.setLayout(new BoxLayout(application.getContentPane(), BoxLayout.Y_AXIS));
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(new Object[][]{{"routine 1", "arms", "bicep curls, tricep dips"}, {"routine 2", "arms", "bicep curls, tricep dips"}}, new String[]{"Routine Name", "Tagret", "Exercises"})
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (col == 0) {
                    //link to single workout view
                    String cellValue = (String) table.getValueAt(row, col);
                    System.out.println(cellValue);

//                    LookUpRoutineInteractor.execute()
                    JOptionPane.showMessageDialog(application, "Clicked on cell: " + cellValue);
                }

            }
        });
        JPanel buttons = new JPanel();
        JButton add = new JButton("Add");

        add.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(add)) {
                            System.out.println("clicked");
                        }
                    }
                }
        );
        buttons.add(add);


        application.add(title);
        application.add(tableScrollPane);
        application.add(buttons);

        // Adjust the size of the JFrame to fit the components
        application.pack();

        // Center the JFrame on the screen

        // Make the JFrame visible
        application.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

