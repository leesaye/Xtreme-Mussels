package use_case.delete_routine;


public class DeleteRoutineInteractor implements DeleteRoutineInputBoundary{
    final DeleteRoutineDataAccessInterface deleteRoutineDataAccessObject;

    final DeleteRoutineOutputBoundary deleteRoutinePresenter;

    public DeleteRoutineInteractor(DeleteRoutineDataAccessInterface deleteRoutineDataAccessObject,
                                    DeleteRoutineOutputBoundary deleteRoutineOutputBoundary) {
        this.deleteRoutineDataAccessObject = deleteRoutineDataAccessObject;
        this.deleteRoutinePresenter = deleteRoutineOutputBoundary;
    }

    @Override
    public void execute(DeleteRoutineInputData deleteRoutineInputData) {
        String routineName = deleteRoutineInputData.getRoutineName();

        // Check routine with id corresponding to id exists
        if (!deleteRoutineDataAccessObject.existsByName(routineName)) {
            deleteRoutinePresenter.prepareFailView("Selected routine does not exist");
            // Check exercise with name corresponding to exerciseName exists
        } else {
            // Delete the routine named routineName
            deleteRoutineDataAccessObject.deleteRoutine(routineName);
            deleteRoutinePresenter.prepareSuccessView(new DeleteRoutineOutputData(routineName));
        }

    }
}
