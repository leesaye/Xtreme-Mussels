package interface_adapter.reorder_routine;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReorderRoutineViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Reorder routine view";

    public static final String SAVE_BUTTON_LABEL = "Save";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String[] COLUMN_HEADERS = {"Exercises", "Sets and Reps"};

    private static ReorderRoutineState state = new ReorderRoutineState();

    public ReorderRoutineViewModel() {
        super("reorder");
    }

    public void setState(ReorderRoutineState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static ReorderRoutineState getState() {
        return state;
    }
}
