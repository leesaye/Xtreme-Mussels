package interface_adapter.delete_exercise;

import interface_adapter.ViewModel;
import interface_adapter.delete_exercise.DeleteExerciseState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteExerciseViewModel extends ViewModel{
    private static DeleteExerciseState state = new DeleteExerciseState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public DeleteExerciseViewModel() {
        super("delete");
    }

    public void setState(DeleteExerciseState state) {this.state = state; }

    /**
     *
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);

    }

    public static DeleteExerciseState getState() {
        return state;
    }
}
