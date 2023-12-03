package interface_adapter.lookup_routine;

import entity.Exercise;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LookUpRoutineViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Routine View";

    public static final String BACK_BUTTON_LABEL = "Back";

    private LookUpRoutineState state = new LookUpRoutineState();

    public LookUpRoutineViewModel() {
        super("look up routine");
    }

    public void setState(LookUpRoutineState state) {this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LookUpRoutineState getState() {
        return state;
    }


}
