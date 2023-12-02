package interface_adapter.lookup;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LookUpViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Look Up View";

    public static final String TARGET_LOOKUP_BUTTON_LABEL = "By target muscle";

    public static final String NAME_LOOKUP_BUTTON_LABEL = "By name";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private static LookUpState state = new LookUpState();

    public LookUpViewModel(String viewName) {
        super("look up exercise");
    }

    public void setState(LookUpState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static LookUpState getState() {
        return state;
    }
}
