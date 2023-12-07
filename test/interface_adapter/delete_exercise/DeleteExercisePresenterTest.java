package interface_adapter.delete_exercise;

import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.delete_exercise.DeleteExerciseOutputBoundary;
import use_case.delete_exercise.DeleteExerciseOutputData;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteExercisePresenterTest {

    @Test
    void prepareSuccessView() {
        DeleteExerciseViewModel deleteView = new DeleteExerciseViewModel() {
            private DeleteExerciseState state = new DeleteExerciseState();

            public DeleteExerciseState getState() {return state;}

            public void firePropertyChanged() {
                assertEquals("r1", state.getName());
                String[][] expected = {{}};
                assertEquals(Arrays.toString(expected[0]), Arrays.toString(state.getExercisesDisplay()[0]));
            }
        };

        ViewManagerModel viewManager = new ViewManagerModel();
        DeleteExerciseOutputBoundary presenter = new DeleteExercisePresenter(viewManager, deleteView);

        Routine routine = new Routine("r1");
        routine.setName("r1");
        Exercise bc = ExerciseFactory.create("bear crawl", "cardiovascular systen", "bpdy weight", null, "3360", 3, 15);
        routine.getExercisesList().add(bc);

        routine.getExercisesList().remove(bc);
        presenter.prepareSuccessView(new DeleteExerciseOutputData("r1", "bear crawl", routine));
    }

    @Test
    void prepareFailView() {
        DeleteExerciseViewModel deleteViewModel = new DeleteExerciseViewModel() {
            private DeleteExerciseState state = new DeleteExerciseState();

            public DeleteExerciseState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("nonexistent", state.getRoutineNameError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        DeleteExerciseOutputBoundary presenter = new DeleteExercisePresenter(viewManagerModel, deleteViewModel);

        presenter.prepareFailView("nonexistent");
    }
}