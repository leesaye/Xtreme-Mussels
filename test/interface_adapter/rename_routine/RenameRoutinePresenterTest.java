package interface_adapter.rename_routine;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.rename_routine.RenameRoutineOutputBoundary;
import use_case.rename_routine.RenameRoutineOutputData;

import java.beans.PropertyChangeSupport;

import static org.junit.jupiter.api.Assertions.*;

class RenameRoutinePresenterTest {

    @Test
    void prepareSuccessTest() {
        RenameRoutineViewModel renameViewModel = new RenameRoutineViewModel() {

            private RenameRoutineState state = new RenameRoutineState();

            public RenameRoutineState getState() {
                return state;
            }

            public void firePropertyChanged() {
                assertEquals("new", state.getName());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RenameRoutineOutputBoundary presenter = new RenameRoutinePresenter(viewManagerModel, renameViewModel);

        presenter.prepareSuccessView(new RenameRoutineOutputData("new"));


    }

    @Test
    void prepareFailTest() {
        RenameRoutineViewModel renameViewModel = new RenameRoutineViewModel() {

            private RenameRoutineState state = new RenameRoutineState();

            public RenameRoutineState getState() {
                return state;
            }

            public void firePropertyChanged() {
                assertEquals("rename error", state.getName());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RenameRoutineOutputBoundary presenter = new RenameRoutinePresenter(viewManagerModel, renameViewModel);

        presenter.prepareFailView("rename error");
    }
}