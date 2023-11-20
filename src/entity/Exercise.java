package entity;

import java.util.ArrayList;

public class Exercise {
    private String name;
    private String target;
    private String equipment;
    private ArrayList<String> instructions;
    private String id;
    private int sets;
    private int reps;

    public Exercise(String name, String target, String equipment, ArrayList<String> instructions, String id, int sets, int reps) {
        this.name = name;
        this.target = target;
        this.equipment = equipment;
        this.instructions = instructions;
        this.id = id;
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public String getTarget() {
        return target;
    }

    public String getEquipment() {
        return equipment;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public String getId() {
        return id;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
