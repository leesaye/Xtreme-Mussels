package use_case.generate_routine;

import entity.Exercise;
import entity.Routine;
import entity.RoutineFactory;

import java.util.ArrayList;
import java.util.Random;

public class GenerateRoutineInteractor implements GenerateRoutineInputBoundary {

    private final GenerateRoutineDataAccessInterface generateRoutineDataAccessObject;
    private final GenerateRoutineOutputBoundary generateRoutinePresenter;


    public GenerateRoutineInteractor(GenerateRoutineDataAccessInterface generateRoutineDataAccessObject, GenerateRoutineOutputBoundary generateRoutinePresenter) {
        this.generateRoutineDataAccessObject = generateRoutineDataAccessObject;
        this.generateRoutinePresenter = generateRoutinePresenter;
    }

    // creating a method to randomly generate the number of sets and reps
    public static int randomGenerator(int min, int max) {
        int range = max - min + 1;
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * range) + min;
        }
        return range;
    }

    @Override
    public void execute (GenerateRoutineInputData generateRoutineInputData){
        String target = generateRoutineInputData.getTargetBodyPart();
        int numberOfExercises = generateRoutineInputData.getNumberOfExercises();
        ArrayList<Exercise> listOfExercises = generateRoutineDataAccessObject.getExercisesByTarget(target, numberOfExercises);
        if (listOfExercises.isEmpty()) {
            generateRoutinePresenter.prepareFailedView("Routine could not created due to insufficient number of exercises");
        }

        String name = generateRoutineInputData.getName();

        int randomSets = randomGenerator(1,5);
        int randomReps = randomGenerator(10,20);

        for (int i = 0; i < listOfExercises.size(); i++) {
            Exercise curr = listOfExercises.get(i);
            curr.setReps(randomReps);
            curr.setSets(randomSets);
        }


        Routine generatedRoutine = RoutineFactory.create(name);
            generatedRoutine.setExercisesList(listOfExercises);
            generateRoutineDataAccessObject.addRoutine(generatedRoutine);

            GenerateRoutineOutputData generateRoutineOutputData = new GenerateRoutineOutputData(listOfExercises, name);
            generateRoutinePresenter.prepareSuccessView(generateRoutineOutputData);
    }


}


