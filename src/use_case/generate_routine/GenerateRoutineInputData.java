package use_case.generate_routine;

public class GenerateRoutineInputData {
    private String targetBodyPart;
    private int numberOfExercises;
    private String name;

    public GenerateRoutineInputData(String targetBodyPart, int numberOfExercises, String name) {
        this.targetBodyPart = targetBodyPart;
        this.numberOfExercises = numberOfExercises;
    }

    public String getTargetBodyPart() {
        return targetBodyPart;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public String getName() {
        return name;}
}

