package interface_adapter.delete_routine;

import use_case.delete_routine.DeleteRoutineInputBoundary;
import use_case.delete_routine.DeleteRoutineInputData;


public class DeleteRoutineController {
    final DeleteRoutineInputBoundary deleteRoutineUseCaseInteractor;

    public DeleteRoutineController(DeleteRoutineInputBoundary deleteRoutineUseCaseInteractor) {
        this.deleteRoutineUseCaseInteractor = deleteRoutineUseCaseInteractor;
    }

    public void execute(String routineName) {
        DeleteRoutineInputData deleteRoutineInputData = new DeleteRoutineInputData(routineName);
        deleteRoutineUseCaseInteractor.execute(deleteRoutineInputData);
    }
}
