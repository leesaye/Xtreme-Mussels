package interface_adapter.generate_routine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GenerateRoutineViewModel {

    private GenerateRoutineState generateRoutineState = new GenerateRoutineState();

    public void setGenerateRoutineState(GenerateRoutineState generateRoutineState) {
        this.generateRoutineState = generateRoutineState;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.generateRoutineState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public GenerateRoutineState getGenerateRoutineState() {
        return generateRoutineState;
    }
}
