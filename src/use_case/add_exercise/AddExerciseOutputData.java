package use_case.add_exercise;

public class AddExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use cases? **/

    private final int id;
    private final String name; // message: Added <name> to routine id
    public AddExerciseOutputData(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
