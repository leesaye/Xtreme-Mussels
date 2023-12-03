package interface_adapter.lookup_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LookUpRoutinesViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Routine View";

    public static final String BACK_BUTTON_LABEL = "Back";

    private static LookUpRoutinesState state = new LookUpRoutinesState();

    public LookUpRoutinesViewModel(String viewName) {
        super("look up routine");
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

    public static LookUpRoutinesState getState() {
        return state;
    }
}
