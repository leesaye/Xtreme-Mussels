package use_case.lookup;
import entity.Exercise;

import java.util.ArrayList;

public interface LookUpDataAccessInterface {
    ArrayList<Exercise> getExercisesByQuery(String value, String query);
}
