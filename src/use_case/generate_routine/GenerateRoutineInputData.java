package use_case.generate_routine;

public class GenerateRoutineInputData {
    private String targetBodyPart;
    private int numberOfExercises;

    public GenerateRoutineInputData(String targetBodyPart, int numberOfExercises) {
        this.targetBodyPart = targetBodyPart;
        this.numberOfExercises = numberOfExercises;
    }

    public String getTargetBodyPart() {
        return targetBodyPart;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }
}
