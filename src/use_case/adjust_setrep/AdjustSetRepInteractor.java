package use_case.adjust_setrep;

public class AdjustSetRepInteractor implements AdjustSetRepInputBoundary {
    final AdjustSetRepDataAccessInterface adjustDataAccessObject;

    final AdjustSetRepOutputBoundary adjustPresenter;

    public AdjustSetRepInteractor(AdjustSetRepDataAccessInterface adjustDataAccessObject,
                                  AdjustSetRepOutputBoundary adjustSetRepOutputBoundary) {
        this.adjustDataAccessObject = adjustDataAccessObject;
        this.adjustPresenter = adjustSetRepOutputBoundary;
    }


    @Override
    public void execute(AdjustSetRepInputData adjustSetRepInputData) {
        int id = adjustSetRepInputData.getId();

        // check the given id actually exists (it should exist since it's generated for user)
        if (!adjustDataAccessObject.existsById(id)) {
            adjustPresenter.prepareFailView(id + ": Routine does not exist");
        } else {
            // Update the routine with the new name and exercises/sets
            adjustDataAccessObject.updateRoutine(id, adjustSetRepInputData.getSets(), adjustSetRepInputData.getReps());
            adjustPresenter.prepareSuccessView(new AdjustSetRepOutputData("temp proraory")); // TODO: change this
        }
    }
}
