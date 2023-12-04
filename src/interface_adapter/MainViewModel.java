package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Xtreme Mussels";
    public static final String LOOKUP_LABEL = "Look Up Exercises";
    public static final String VIEWALL_LABEL = "View Routines";


    public MainViewModel(String viewName) {
        super(viewName);
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
    }
}
