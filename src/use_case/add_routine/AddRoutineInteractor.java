package use_case.add_routine;

import entity.Routine;
import entity.RoutineFactory;

public class AddRoutineInteractor implements AddRoutineInputBoundary{
    final AddRoutineOutputBoundary addRoutinePresenter;
    final AddRoutineDataAccessInterface addRoutineDataAccessObject;
    final RoutineFactory routineFactory;
    private static int lastAssignedId = 0;

    private synchronized int generateId() {
        return ++lastAssignedId; // generate an id for each routine created
    }

    public AddRoutineInteractor(AddRoutineDataAccessInterface addRoutineDataAccessObject,
                                AddRoutineOutputBoundary addRoutineOutputBoundary, RoutineFactory routineFactory) {
        this.addRoutineDataAccessObject = addRoutineDataAccessObject;
        this.addRoutinePresenter = addRoutineOutputBoundary;
        this.routineFactory = routineFactory;
    }

    @Override
    public void execute(AddRoutineInputData addRoutineInputData) {
        if (addRoutineDataAccessObject.existsByName(addRoutineInputData.getRoutineName())) {
            addRoutinePresenter.prepareFailView("Routine name already exists.");
        } else {

            AddRoutineOutputData addRoutineOutputData = new AddRoutineOutputData(addRoutineDataAccessObject.addRoutine());
            addRoutinePresenter.prepareSuccessView(addRoutineOutputData);
            Routine routine = new Routine(generateId(), addRoutineInputData.getRoutineName());
            addRoutineDataAccessObject.save(routine);
        }
    }
}