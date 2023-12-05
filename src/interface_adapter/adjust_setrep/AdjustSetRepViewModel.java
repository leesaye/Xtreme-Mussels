package interface_adapter.adjust_setrep;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AdjustSetRepViewModel extends ViewModel {
    public static final String ADJUST_BUTTON_LABEL = "Save sets and reps";

    private AdjustSetRepState state = new AdjustSetRepState();

    public AdjustSetRepViewModel() {
        super("adjust");
    }

    public void setState(AdjustSetRepState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AdjustSetRepState getState() {
        return state;
    }
}
