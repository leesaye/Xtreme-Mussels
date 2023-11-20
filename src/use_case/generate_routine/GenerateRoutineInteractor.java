package use_case.generate_routine;

import java.util.ArrayList;

public class GenerateRoutineInteractor implements GenerateRoutineInputBoundary {

    private final GenerateRoutineDataAccessInterface generateRoutineDataAccessObject;
    private final GenerateRoutineOutputBoundary generateRoutinePresenter;

    public GenerateRoutineInteractor(GenerateRoutineDataAccessInterface generateRoutineDataAccessObject, GenerateRoutineOutputBoundary generateRoutinePresenter) {
        this.generateRoutineDataAccessObject = generateRoutineDataAccessObject;
        this.generateRoutinePresenter = generateRoutinePresenter;
    }

    @Override
    public void execute(GenerateRoutineInputData generateRoutineInputData) {
        try {
            String target = generateRoutineInputData.getTargetBodyPart();
            int numberOfExercises = generateRoutineInputData.getNumberOfExercises();
            ArrayList listOfExercises = generateRoutineDataAccessObject.getExercisesByTarget(target, numberOfExercises);
            GenerateRoutineOutputData generateRoutineOutputData = new GenerateRoutineOutputData(listOfExercises);
            generateRoutinePresenter.prepareSuccessView(generateRoutineOutputData);
        } catch(Exception e) {
            generateRoutinePresenter.prepareFailedView("Error"); //TODO: add a more specific error message
        }
    }
}
