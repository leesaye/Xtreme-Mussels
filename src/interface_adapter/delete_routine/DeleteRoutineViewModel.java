package interface_adapter.delete_routine;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteRoutineViewModel extends ViewModel {
    public static String DELETE_ROUTINE_BUTTON_LABEL = "Delete routine";
    private DeleteRoutineState state = new DeleteRoutineState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteRoutineViewModel() {
        super("delete routine");
    }

    public void setState(DeleteRoutineState state) {this.state = state; }

    public DeleteRoutineState getState() {return state; }

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {support.addPropertyChangeListener(listener);}
}
