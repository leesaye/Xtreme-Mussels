package use_case.lookup;
import entity.Exercise;

import java.util.ArrayList;

public interface LookUpDataAccessInterface {
    ArrayList<Exercise> getExercises(String target);
    void save(ArrayList<Exercise> exercises);
}
