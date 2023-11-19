package interface_adapter.reorder_routine;

import use_case.reorder_routine.ReorderRoutineInputBoundary;
import entity.Exercise;
import use_case.reorder_routine.ReorderRoutineInputData;

import java.util.ArrayList;

public class ReorderRoutineController {

    final ReorderRoutineInputBoundary reorderUseCaseInteractor;

    public ReorderRoutineController(ReorderRoutineInputBoundary reorderUseCaseInteractor) {
        this.reorderUseCaseInteractor = reorderUseCaseInteractor;
    }

    public void execute(int id, ArrayList<Exercise> exercises) {
        ReorderRoutineInputData reorderInputData = new ReorderRoutineInputData(id, exercises);

        reorderUseCaseInteractor.execute(reorderInputData);
    }
}
