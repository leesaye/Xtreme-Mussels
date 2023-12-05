package use_case.rename_routine;

public class RenameRoutineInputData {

    final private String id;

    final private String name;

    public RenameRoutineInputData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }

    public String getName() { return name; }

}
