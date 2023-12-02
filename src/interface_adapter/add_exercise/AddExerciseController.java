package interface_adapter.add_exercise;


import java.util.ArrayList;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInputData;

public class AddExerciseController {
    final AddExerciseInputBoundary addExerciseUseCaseInteractor;

    public AddExerciseController(AddExerciseInputBoundary addExerciseUseCaseInteractor) {
       this.addExerciseUseCaseInteractor = addExerciseUseCaseInteractor;
    }

    public void execute(String routine_name, String name) {
        AddExerciseInputData addExerciseInputData = new AddExerciseInputData(routine_name, name);
        addExerciseUseCaseInteractor.execute(addExerciseInputData);
    }
}