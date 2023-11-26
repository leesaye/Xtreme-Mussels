package interface_adapter.rename_routine;

public class RenameRoutineState {

    private String name;

    private int id;

    private String nameError;

    public RenameRoutineState() {
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getNameError() { return nameError; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setNameError(String nameError) { this.nameError = nameError; }
}
