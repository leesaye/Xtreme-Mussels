package interface_adapter.delete_exercise;

import use_case.delete_exercise.DeleteExerciseInputBoundary;
import use_case.delete_exercise.DeleteExerciseInputData;

public class DeleteExerciseController{
    final DeleteExerciseInputBoundary deleteExerciseUseCaseInteractor;

    public DeleteExerciseController(DeleteExerciseInputBoundary deleteExerciseUseCaseInteractor) {
        this.deleteExerciseUseCaseInteractor = deleteExerciseUseCaseInteractor;
    }

    public void execute(String routineName, String exerciseName) {
        //pass in data / exercise name?
        DeleteExerciseInputData addExerciseInputData = new DeleteExerciseInputData(routineName, exerciseName);
        deleteExerciseUseCaseInteractor.execute(addExerciseInputData);
    }

}
