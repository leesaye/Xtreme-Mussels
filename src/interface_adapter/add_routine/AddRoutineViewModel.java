package interface_adapter.add_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddRoutineViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Routines";
    public static final String ROUTINE_NAME_LABEL = "Choose routine name";
    public static final String Add_ROUTINE_BUTTON_LABEL = "Add Routine";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
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
