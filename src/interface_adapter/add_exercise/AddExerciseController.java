package interface_adapter.add_exercise;


import java.util.ArrayList;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInputData;

public class AddExerciseController {
    final AddExerciseInputBoundary addExerciseUseCaseInteractor;

    public AddExerciseController(AddExerciseInputBoundary addExerciseUseCaseInteractor) {
       this.addExerciseUseCaseInteractor = addExerciseUseCaseInteractor;
    }

    public void execute(int id, String name) {
        //pass in data / exercise name?
        AddExerciseInputData addExerciseInputData = new AddExerciseInputData(id, name);
        addExerciseUseCaseInteractor.execute(addExerciseInputData);
    }
}