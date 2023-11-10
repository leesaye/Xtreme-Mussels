package interface_adapter.edit_routine;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditRoutineViewModel extends ViewModel {

    private EditRoutineState state = new EditRoutineState();

    public EditRoutineViewModel() {
        super("clear");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditRoutineState getState() {
        return state;
    }
}
