package interface_adapter.generate_routine;

import use_case.generate_routine.GenerateRoutineInputBoundary;
import use_case.generate_routine.GenerateRoutineInputData;

public class GenerateRoutineController {
    final GenerateRoutineInputBoundary generateRoutineUseCaseInteractor;

    public GenerateRoutineController(GenerateRoutineInputBoundary generateRoutineUseCaseInteractor) {
        this.generateRoutineUseCaseInteractor = generateRoutineUseCaseInteractor;
    }

    public void execute(String targetBodyParts, int numberOfExercises, String name) {
        GenerateRoutineInputData generateRoutineInputData = new GenerateRoutineInputData(targetBodyParts, numberOfExercises, name);
        generateRoutineUseCaseInteractor.execute(generateRoutineInputData);
    }
}
