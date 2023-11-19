package interface_adapter.reorder_routine;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReorderRoutineViewModel extends ViewModel {

    private ReorderRoutineState state = new ReorderRoutineState();

    public ReorderRoutineViewModel() {
        super("reorder");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ReorderRoutineState getState() {
        return state;
    }
}
