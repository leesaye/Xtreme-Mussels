package interface_adapter.adjust_setrep;

import entity.Exercise;
import entity.Routine;
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
                String[][] expected = {{"Bicep curls", "4", "12"}};
                assertEquals(expected[0][0], state.getExercisesDisplay()[0][0]);
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AdjustSetRepOutputBoundary presenter = new AdjustSetRepPresenter(viewManagerModel, adjustViewModel);

        Routine routine = new Routine("Routine");
        routine.setName("Routine");
        Exercise bicep = new Exercise("Bicep curls", "bicep", "Dumbbells", null, "bicep curls", 3, 15);
        routine.getExercisesList().add(bicep);

        presenter.prepareSuccessView(new AdjustSetRepOutputData("updated", routine));
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