package interface_adapter.rename_routine;

import use_case.rename_routine.RenameRoutineInputBoundary;
import use_case.rename_routine.RenameRoutineInputData;

public class RenameRoutineController {

    final RenameRoutineInputBoundary renameRoutineInteractor;

    public RenameRoutineController(RenameRoutineInputBoundary renameRoutineInteractor) {
        this.renameRoutineInteractor = renameRoutineInteractor;
    }

    public void execute(int id, String name) {
        RenameRoutineInputData renameRoutineInputData = new RenameRoutineInputData(id, name);

        renameRoutineInteractor.execute(renameRoutineInputData);
    }
}
