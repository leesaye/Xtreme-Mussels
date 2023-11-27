package use_case.delete_exercise;

import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_exercise.AddExerciseInputData;
import use_case.add_exercise.AddExerciseOutputBoundary;

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
        int id = deleteExerciseInputData.getId();
        String exercise_name = deleteExerciseInputData.getName();

        // Check routine with id corresponding to id exists
        if (!deleteExerciseDataAccessObject.existsById(id)) {
            // Use exceptions? instead
            // addExercisePresenter.prepareFailView("Routine" + id + "does not exist"); - temp until presenter implemented
            // Check exercise with name corresponding to exercise_name exists
        } else if (!deleteExerciseDataAccessObject.existsByName(exercise_name)) {

        } else {
            // Update the routine corresponding to id by adding the exercise corresponding to exercise_name
            deleteExerciseDataAccessObject.updateRoutine(id, exercise_name);
            //addExercisePresenter.prepareSuccessView(new AddExerciseOutputData()); - as above
        }

    }
}
