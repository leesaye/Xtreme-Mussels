package use_case.rename_routine;

public class RenameRoutineInteractor implements RenameRoutineInputBoundary {

    final RenameRoutineDataAccessInterface renameRoutineDataAccessObject;

    final RenameRoutineOutputBoundary renameRoutinePresenter;

    public RenameRoutineInteractor(RenameRoutineDataAccessInterface renameRoutineDataAccessObject,
                                   RenameRoutineOutputBoundary renameRoutinePresenter) {
        this.renameRoutineDataAccessObject = renameRoutineDataAccessObject;
        this.renameRoutinePresenter = renameRoutinePresenter;
    }

    @Override
    public void execute(RenameRoutineInputData renameRoutineInputData) {
        int id = renameRoutineInputData.getId();

        if (!renameRoutineDataAccessObject.existsById(id)) {
            renameRoutinePresenter.prepareFailView(id + ": Routine does not exist");
        } else {
            renameRoutineDataAccessObject.changeName(id, renameRoutineInputData.getName());
            renameRoutinePresenter.prepareSuccessView(new RenameRoutineOutputData(renameRoutineInputData.getName()));
        }
    }
}
