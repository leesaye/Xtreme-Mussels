package interface_adapter.rename_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RenameRoutineViewModel extends ViewModel {

    public static String RENAME_BUTTON_LABEL = "Rename";

    private static RenameRoutineState state = new RenameRoutineState();

    public RenameRoutineViewModel() { super("rename"); }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static RenameRoutineState getState() {
        return state;
    }
}
