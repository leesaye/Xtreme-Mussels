package interface_adapter.rename_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RenameRoutineViewModel extends ViewModel {

    public static String RENAME_BUTTON_LABEL = "Rename";

    private RenameRoutineState state = new RenameRoutineState();

    public RenameRoutineViewModel() { super("rename"); }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public RenameRoutineState getState() { return state; }
}
