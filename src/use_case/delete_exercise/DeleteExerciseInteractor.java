package use_case.delete_exercise;

public class DeleteExerciseInteractor implements DeleteExerciseInputBoundary{

    /**
     * @param deleteExerciseInputData
     */
    final DeleteExerciseDataAccessInterface deleteExerciseDataAccessObject;

    final DeleteExerciseOutputBoundary deleteExercisePresenter;

    public DeleteExerciseInteractor(DeleteExerciseDataAccessInterface deleteExerciseDataAccessObject,
                                    DeleteExerciseOutputBoundary deleteExerciseOutputBoundary) {
        this.deleteExerciseDataAccessObject = deleteExerciseDataAccessObject;
        this.deleteExercisePresenter = deleteExerciseOutputBoundary;
    }

    @Override
    public void execute(DeleteExerciseInputData deleteExerciseInputData) {
        String routineName = deleteExerciseInputData.getRoutineName();
        String exerciseName = deleteExerciseInputData.getExerciseName();

        // Check routine with id corresponding to id exists
        if (!deleteExerciseDataAccessObject.existsByName(routineName)) {
            // Use exceptions? instead
            deleteExercisePresenter.prepareFailView("Selected routine does not exist");
            // Check exercise with name corresponding to exercise_name exists
        } else if (!deleteExerciseDataAccessObject.existsById(routineName, exerciseName)) {
            deleteExercisePresenter.prepareFailView("Selected exercise does not exist in specified routine");
        } else {
            // Update the routine named routine_name by adding the exercise corresponding to exercise_name
            deleteExerciseDataAccessObject.deleteExercise(routineName, exerciseName);
            deleteExercisePresenter.prepareSuccessView(new DeleteExerciseOutputData(routineName, exerciseName, deleteExerciseDataAccessObject.getRoutine(routineName)));
        }

    }
}
