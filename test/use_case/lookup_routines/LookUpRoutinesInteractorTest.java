package use_case.lookup_routine;

import data_access.RoutineDataAccessObject;
import entity.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.lookup_routines.LookUpRoutinesInteractor;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import use_case.lookup_routines.LookUpRoutinesOutputData;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LookUpRoutinesInteractorTest {
    HashMap<String, Routine> routineList = new HashMap<>();

    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
        routineList = routineDataAccessObject.getRoutineList();
    }

    @Test
    void successTest() {
        LookUpRoutinesOutputBoundary lookUpRoutinesPresenter = new LookUpRoutinesOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpRoutinesOutputData output) {
                assertThat(output.getAllRoutines().get(0).getName(), anyOf(is("test1"), is("test2"), is("test3")));
                assertThat(output.getAllRoutines().get(1).getName(), anyOf(is("test1"), is("test2"), is("test3")));
                assertThat(output.getAllRoutines().get(2).getName(), anyOf(is("test1"), is("test2"), is("test3")));
            }
        };

        LookUpRoutinesInteractor interactor = new LookUpRoutinesInteractor(routineDataAccessObject, lookUpRoutinesPresenter);
        interactor.execute();
    }
}

class TestRoutinesDataAccess {
    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
    }

    @Test
    void getRoutinesTest() {
        assertEquals(routineDataAccessObject.getRoutines().size(), 3);
        assertThat(routineDataAccessObject.getRoutines().get(0).getName(), anyOf(is("test1"), is("test2"), is("test3")));
    }
}
