package interface_adapter.adjust_setrep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.adjust_setrep.AdjustSetRepInputBoundary;
import use_case.adjust_setrep.AdjustSetRepInputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdjustSetRepControllerTest {

    ArrayList<Integer> sets;

    ArrayList<Integer> reps;

    @BeforeEach // Technically not needed since there's only one test in here
    void init() {
        sets = new ArrayList<>();
        sets.add(3);
        sets.add(4);
        sets.add(5);

        reps = new ArrayList<>();
        reps.add(12);
        reps.add(13);
        reps.add(14);
    }

    @Test
    void test() {
        AdjustSetRepInputBoundary interactor = new AdjustSetRepInputBoundary() {

            @Override
            public void execute(AdjustSetRepInputData adjustInputData) {
                assertEquals(1, adjustInputData.getId());
                assertEquals(sets, adjustInputData.getSets());
                assertEquals(reps, adjustInputData.getReps());
            }
        };

        AdjustSetRepController controller = new AdjustSetRepController(interactor);

        controller.execute(1, sets, reps);
    }
}