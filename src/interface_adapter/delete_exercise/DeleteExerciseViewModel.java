package interface_adapter.delete_exercise;

import interface_adapter.ViewModel;
import interface_adapter.delete_exercise.DeleteExerciseState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteExerciseViewModel extends ViewModel{

    public static String DELETE_BUTTON_LABEL = "Delete exercise";
    private DeleteExerciseState state = new DeleteExerciseState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public DeleteExerciseViewModel() {
        super("delete");
    }

    public void setState(DeleteExerciseState state) {this.state = state; }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    public DeleteExerciseState getState() {
        return state;
    }
}
