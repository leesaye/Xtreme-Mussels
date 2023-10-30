package entity;

import java.util.ArrayList;

public class Exercise {
    private String name;
    private String difficulty;
    private String target;
    private ArrayList secondaryMuscles;
    private String equipment;
    private String gifURL;
    private int id;
    private ArrayList instructions;

    public Exercise(String name, String difficulty, String target, ArrayList secondaryMuscles, String equipment, String gifURL, int id, ArrayList instructions) {
        this.name = name;
        this.difficulty = difficulty;
        this.target = target;
        this.secondaryMuscles = secondaryMuscles;
        this.equipment = equipment;
        this.gifURL = gifURL;
        this.id = id;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTarget() {
        return target;
    }

    public ArrayList getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getGifURL() {
        return gifURL;
    }

    public int getId() {
        return id;
    }

    public ArrayList getInstructions() {
        return instructions;
    }
}
