package use_case.delete_exercise;

public class DeleteExerciseOutputData {
    /* is output data for this use case the updated routine or something more like
     * a success message like the other edit-related use case? **/

    private final int id;
    private final String name; // message: Added <name> to routine id
    public DeleteExerciseOutputData(int id, String name) {

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
