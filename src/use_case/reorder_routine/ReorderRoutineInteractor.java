package use_case.reorder_routine;

public class ReorderRoutineInteractor implements ReorderRoutineInputBoundary {
    final ReorderRoutineDataAccessInterface editDataAccessObject;

    final ReorderRoutineOutputBoundary editPresenter;

    public ReorderRoutineInteractor(ReorderRoutineDataAccessInterface editDataAccessObject,
                                    ReorderRoutineOutputBoundary reorderRoutineOutputBoundary) {
        this.editDataAccessObject = editDataAccessObject;
        this.editPresenter = reorderRoutineOutputBoundary;
    }


    @Override
    public void execute(ReorderRoutineInputData editInputData) {
        String name = editInputData.getName();
        int id = editInputData.getId();

        // check the given id actually exists (it should exist since it's generated for user)
        if (!editDataAccessObject.existsById(id)) {
            editPresenter.prepareFailView(name + ": Routine does not exist");
        } else {
            // Update the routine with the new name and exercises/sets
            editDataAccessObject.updateRoutine(id, name, editInputData.getExercises(),
                    editInputData.getReps(), editInputData.getSets());
            editPresenter.prepareSuccessView(new ReorderRoutineOutputData(name));
        }
    }
}
