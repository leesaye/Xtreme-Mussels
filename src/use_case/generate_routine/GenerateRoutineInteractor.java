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
        try {
            String target = generateRoutineInputData.getTargetBodyPart();
            int numberOfExercises = generateRoutineInputData.getNumberOfExercises();
            ArrayList<Exercise> listOfExercises = generateRoutineDataAccessObject.getExercisesByTarget(target, numberOfExercises);
            String name = generateRoutineInputData.getName();

//                // Checking to see if the listOfExercises is not empty, because of invalid input:
//                if (listOfExercises.isEmpty()) {
//                    throw new IllegalArgumentException("Inputted invalid target");
//                }
//
//                // Checking to see if the name is duplicated:
////                if (name in ___) {
////                    throw new IllegalArgumentException("Choose another name!");
////                }
//                //TODO: go through the list of exercises to change the reps and sets

            int randomSets = randomGenerator(1,5);
            int randomReps = randomGenerator(10,20);
            for (int i = 0; i < listOfExercises.size(); i++) {
                Exercise curr = listOfExercises.get(i);
                curr.setReps(randomReps);
                curr.setSets(randomSets);
            }
            //TODO: add the create workout method with param RoutineFactory.create(name, arraylist)
//            Routine generatedRoutine = RoutineFactory.create(name);
//            generatedRoutine.setExercisesList(listOfExercises);
//            generateRoutineDataAccessObject.addRoutine(generatedRoutine);


            GenerateRoutineOutputData generateRoutineOutputData = new GenerateRoutineOutputData(listOfExercises, name);
            generateRoutinePresenter.prepareSuccessView(generateRoutineOutputData);
        } catch (Exception e) {
            generateRoutinePresenter.prepareFailedView("Routine could not be created"); //TODO: add a more specific error message
        }
    }


}


