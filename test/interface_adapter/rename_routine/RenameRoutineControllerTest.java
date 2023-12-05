package interface_adapter.rename_routine;

import org.junit.jupiter.api.Test;
import use_case.rename_routine.RenameRoutineInputBoundary;
import use_case.rename_routine.RenameRoutineInputData;
import static org.junit.jupiter.api.Assertions.*;

class RenameRoutineControllerTest {

    @Test
    void test() {
        RenameRoutineInputBoundary renameInteractor = new RenameRoutineInputBoundary() {

            @Override
            public void execute(RenameRoutineInputData renameRoutineInputData) {
                assertEquals("1", renameRoutineInputData.getId());
                assertEquals("old", renameRoutineInputData.getName());
            }
        };

        RenameRoutineController controller = new RenameRoutineController(renameInteractor);

        controller.execute("1", "old");
    }
}