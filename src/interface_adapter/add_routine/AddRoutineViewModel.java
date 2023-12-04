package interface_adapter.add_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddRoutineViewModel extends ViewModel {
    public static String Add_ROUTINE_BUTTON_LABEL = "Add Routine";
    private AddRoutineState state = new AddRoutineState();

    public AddRoutineViewModel(){ super("AddRoutine"); }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Add Routine Presenter calls the ViewModel
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(AddRoutineState state) {
        this.state = state;
    }

    public AddRoutineState getState() {
        return state;
    }
}
