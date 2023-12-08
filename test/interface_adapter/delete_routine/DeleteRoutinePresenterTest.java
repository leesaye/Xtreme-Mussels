package interface_adapter.delete_routine;

import entity.Routine;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.delete_routine.DeleteRoutineOutputBoundary;
import use_case.delete_routine.DeleteRoutineOutputData;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRoutinePresenterTest {

    @Test
    void prepareSuccessView() {
        DeleteRoutineViewModel deleteView = new DeleteRoutineViewModel() {
            private DeleteRoutineState state = new DeleteRoutineState();

            public DeleteRoutineState getState() {return state;}

            public void firePropertyChanged() {
                state.setName("r1");
                assertEquals("r1", state.getName());
            }
        };
        ViewManagerModel viewManager = new ViewManagerModel();
        DeleteRoutineOutputBoundary presenter = new DeleteRoutinePresenter(viewManager, deleteView);

        Routine routine = new Routine("r1");
        routine.setName("r1");
        presenter.prepareSuccessView(new DeleteRoutineOutputData("r1"));
    }

    @Test
    void prepareFailView() {
        DeleteRoutineViewModel deleteViewModel = new DeleteRoutineViewModel() {
            private DeleteRoutineState state = new DeleteRoutineState();

            public DeleteRoutineState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("nonexistent", state.getRoutineNameError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        DeleteRoutineOutputBoundary presenter = new DeleteRoutinePresenter(viewManagerModel, deleteViewModel);
        presenter.prepareFailView("nonexistent");
    }
}