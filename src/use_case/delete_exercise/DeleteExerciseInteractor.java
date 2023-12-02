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
        String routine_name = deleteExerciseInputData.getRoutineName();
        String exercise_name = deleteExerciseInputData.getExerciseName();

        // Check routine with id corresponding to id exists
        if (!deleteExerciseDataAccessObject.existsByName(routine_name )) {
            // Use exceptions? instead
            deleteExercisePresenter.prepareFailView("Routine" + routine_name+ "does not exist");
            // Check exercise with name corresponding to exercise_name exists
        } else if (!deleteExerciseDataAccessObject.existsById(routine_name, exercise_name)) {
            deleteExercisePresenter.prepareFailView("Exercise" + exercise_name+ "does not exist in specified routine");
        } else {
            // Update the routine named routine_name by adding the exercise corresponding to exercise_name
            deleteExerciseDataAccessObject.deleteExercise(routine_name, exercise_name);
            deleteExercisePresenter.prepareSuccessView(new DeleteExerciseOutputData(routine_name, exercise_name));
        }

    }
}
