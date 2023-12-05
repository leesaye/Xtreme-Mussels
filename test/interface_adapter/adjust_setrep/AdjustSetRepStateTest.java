package interface_adapter.adjust_setrep;

import entity.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdjustSetRepStateTest {

    AdjustSetRepState state;

    @BeforeEach
    void init() {
        state = new AdjustSetRepState();
    }

    @Test
    void exercises() {
        ArrayList<Exercise> exercise = new ArrayList<>();
        Exercise bicep = new Exercise("Bicep curls", "bicep", "Dumbbells", null, "bicep curls", 3, 15);
        exercise.add(bicep);

        state.setExercises(exercise);

        assertEquals("Bicep curls", state.getExercises().get(0).getName());
    }

    @Test
    void emptyToStringArray() {
        ArrayList<Exercise> exercise = new ArrayList<>();

        assertEquals(1, state.toStringArray(exercise).length);
    }

    @Test
    void normalToStringArray() {
        ArrayList<Exercise> exercise = new ArrayList<>();
        Exercise bicep = new Exercise("Bicep curls", "bicep", "Dumbbells", null, "bicep curls", 3, 15);
        exercise.add(bicep);

        assertEquals(3, state.toStringArray(exercise)[0].length);
    }

    @Test
    void nameError() {
        state.setRoutineNameError("error");
        assertEquals("error", state.getRoutineNameError());
    }
}