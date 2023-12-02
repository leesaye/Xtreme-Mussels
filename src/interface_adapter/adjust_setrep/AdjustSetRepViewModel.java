package interface_adapter.adjust_setrep;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AdjustSetRepViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Adjust sets and reps routine view";

    public static final String SAVE_BUTTON_LABEL = "Save";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String[] COLUMN_HEADERS = {"Exercises", "Sets", "Reps"};

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
