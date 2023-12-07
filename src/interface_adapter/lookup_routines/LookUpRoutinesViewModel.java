package interface_adapter.lookup_routines;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LookUpRoutinesViewModel extends ViewModel {

    public static final String[] COLUMN_HEADERS = {"Routine Name", "Exercises"};
    public static final String TITLE_LABEL = "All Routines View";
    public static final String ADD_BUTTON_LABEL = "Add new routine manually";
    public static final String CANCEL_BUTTON_LABEL = "Back to main";
    public static final String GENERATE_BUTTON_LABEL = "Generate Routine";

    private LookUpRoutinesState state = new LookUpRoutinesState();

    public LookUpRoutinesViewModel() {
        super("look up all routine");
    }

    public void setState(LookUpRoutinesState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LookUpRoutinesState getState() {
        return state;
    }
}
