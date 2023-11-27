package use_case.add_exercise;


public class AddExerciseInteractor implements AddExerciseInputBoundary{
    final AddExerciseDataAccessInterface addExerciseDataAccessObject;

    final AddExerciseOutputBoundary addExercisePresenter;

    public AddExerciseInteractor(AddExerciseDataAccessInterface addExerciseDataAccessObject,
                                 AddExerciseOutputBoundary addExerciseOutputBoundary) {
        this.addExerciseDataAccessObject = addExerciseDataAccessObject;
        this.addExercisePresenter = addExerciseOutputBoundary;
    }

    @Override
    public void execute(AddExerciseInputData addExerciseInputData) {
        int id = addExerciseInputData.getId();
        String exercise_name = addExerciseInputData.getName();

        // Check routine with id corresponding to id exists
        if (!addExerciseDataAccessObject.existsById(id)) {
            //Use exceptions? instead
            // addExercisePresenter.prepareFailView("Routine" + id + "does not exist"); - temp until presenter implemented
        // Check exercise with name corresponding to exercise_name exists
        } else if (!addExerciseDataAccessObject.existsByName(exercise_name)) {

        } else {
                // Update the routine corresponding to id by adding the exercise corresponding to exercise_name
                addExerciseDataAccessObject.updateRoutine(id, exercise_name);
                //addExercisePresenter.prepareSuccessView(new AddExerciseOutputData()); - as above
        }

    }
}
