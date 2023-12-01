package use_case.rename_routine;

public class RenameRoutineInputData {

    final private int id;

    final private String name;

    public RenameRoutineInputData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

}
