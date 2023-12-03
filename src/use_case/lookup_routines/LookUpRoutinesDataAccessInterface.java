package use_case.lookup_routines;

import entity.Routine;

import java.util.ArrayList;

public interface LookUpRoutinesDataAccessInterface {
    ArrayList<Routine> getRoutines();
}
