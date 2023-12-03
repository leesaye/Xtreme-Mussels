package interface_adapter.generate_routine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class GenerateRoutineViewModel {

    public static final String VIEW_NAME = "Generate Routine";
    public static final String GENERATE_ROUTINE_LABEL = "Generate routine";
    public static final String TARGET_LABEL = "Target body part: ";
    public static final String ROUTINE_NAME = "Routine name: ";
    public static final String NUMBER_EXERCISES_LABEL = "Number of exercises: ";




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

    public abstract void firePropertyChange();
}
