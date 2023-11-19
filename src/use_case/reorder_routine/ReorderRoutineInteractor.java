package use_case.reorder_routine;

public class ReorderRoutineInteractor implements ReorderRoutineInputBoundary {
    final ReorderRoutineDataAccessInterface reorderDataAccessObject;

    final ReorderRoutineOutputBoundary reorderPresenter;

    public ReorderRoutineInteractor(ReorderRoutineDataAccessInterface reorderDataAccessObject,
                                    ReorderRoutineOutputBoundary reorderRoutineOutputBoundary) {
        this.reorderDataAccessObject = reorderDataAccessObject;
        this.reorderPresenter = reorderRoutineOutputBoundary;
    }


    @Override
    public void execute(ReorderRoutineInputData editInputData) {
        String name = editInputData.getName();
        int id = editInputData.getId();

        // check the given id actually exists (it should exist since it's generated for user)
        if (!reorderDataAccessObject.existsById(id)) {
            reorderPresenter.prepareFailView(name + ": Routine does not exist");
        } else {
            // Update the routine with the new name and exercises/sets
            reorderDataAccessObject.updateRoutine(id, name, editInputData.getExercises());
            reorderPresenter.prepareSuccessView(new ReorderRoutineOutputData(name));
        }
    }
}
