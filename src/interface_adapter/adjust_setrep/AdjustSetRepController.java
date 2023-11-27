package interface_adapter.adjust_setrep;

import use_case.adjust_setrep.AdjustSetRepInputBoundary;
import entity.Exercise;
import use_case.adjust_setrep.AdjustSetRepInputData;

import java.util.ArrayList;

public class AdjustSetRepController {

    final AdjustSetRepInputBoundary adjustUseCaseInteractor;

    public AdjustSetRepController(AdjustSetRepInputBoundary adjustUseCaseInteractor) {
        this.adjustUseCaseInteractor = adjustUseCaseInteractor;
    }

    public void execute(int id, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        AdjustSetRepInputData adjustInputData = new AdjustSetRepInputData(id, sets, reps);

        adjustUseCaseInteractor.execute(adjustInputData);
    }
}
