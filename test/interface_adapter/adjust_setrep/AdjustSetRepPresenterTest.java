package interface_adapter.adjust_setrep;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.adjust_setrep.AdjustSetRepOutputBoundary;
import use_case.adjust_setrep.AdjustSetRepOutputData;

import static org.junit.jupiter.api.Assertions.*;

class AdjustSetRepPresenterTest {

    @Test
    void prepareSuccessTest() {
        AdjustSetRepViewModel adjustViewModel = new AdjustSetRepViewModel() {
            private AdjustSetRepState state = new AdjustSetRepState();

            public AdjustSetRepState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("updated", state.getRoutineName());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AdjustSetRepOutputBoundary presenter = new AdjustSetRepPresenter(viewManagerModel, adjustViewModel);

        presenter.prepareSuccessView(new AdjustSetRepOutputData("updated"));
    }

    @Test
    void prepareFailView() {
        AdjustSetRepViewModel adjustViewModel = new AdjustSetRepViewModel() {
            private AdjustSetRepState state = new AdjustSetRepState();

            public AdjustSetRepState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("update fail", state.getRoutineNameError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AdjustSetRepOutputBoundary presenter = new AdjustSetRepPresenter(viewManagerModel, adjustViewModel);

        presenter.prepareFailView("update fail");
    }
}