package interface_adapter.add_routine;

public class AddRoutineViewModel {
    private AddRoutineState state = new AddRoutineState();

    public AddRoutineViewModel() {
        super();
    }

    public void setState(AddRoutineState state) {
        this.state = state;
    }

    public AddRoutineState getState() {
        return state;
    }
}
