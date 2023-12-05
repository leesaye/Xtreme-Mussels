package interface_adapter.delete_exercise;

import use_case.delete_exercise.DeleteExerciseInputBoundary;
import use_case.delete_exercise.DeleteExerciseInputData;

public class DeleteExerciseController{
    final DeleteExerciseInputBoundary deleteExerciseUseCaseInteractor;

    public DeleteExerciseController(DeleteExerciseInputBoundary deleteExerciseUseCaseInteractor) {
        this.deleteExerciseUseCaseInteractor = deleteExerciseUseCaseInteractor;
    }

    public void execute(String routine_name, String exercise_name) {
        //pass in data / exercise name?
        DeleteExerciseInputData deleteExerciseInputData = new DeleteExerciseInputData(routine_name, exercise_name);
        deleteExerciseUseCaseInteractor.execute(deleteExerciseInputData);
    }

}
