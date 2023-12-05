package use_case.add_routine_test;

import data_access.RoutineDataAccessObject;
import entity.Routine;
import entity.RoutineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_routine.*;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

class AddRoutineInteractorTest{
    @BeforeEach
    void init() {
    }

    @Test
    void successTest() {

        HashMap<String, Routine> routineList = null;
        String path = null;

        AddRoutineInputData routineName = new AddRoutineInputData("Routine 1");
        AddRoutineDataAccessInterface addRoutineDataAccessInterface = new RoutineDataAccessObject(routineList, path);

        AddRoutineOutputBoundary addRoutinePresenter = new AddRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {
                assertEquals("Routine 1", addRoutineOutputData.getRoutineName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Add Routine Interactor Test failure unexpected");
            }
        };
        AddRoutineInputBoundary addRoutineInteractor = new AddRoutineInteractor(addRoutineDataAccessInterface, addRoutinePresenter, new RoutineFactory());
        addRoutineInteractor.execute(routineName);

        }

    @Test
    void failureRoutineExistsTest() {

        HashMap<String, Routine> routineList = null;
        String path = null;

        AddRoutineInputData inputData = new AddRoutineInputData("Routine 1");
        AddRoutineInputData repeatInput = new AddRoutineInputData("Routine 1");
        AddRoutineDataAccessInterface addRoutineDataAccessInterface = new RoutineDataAccessObject(routineList, path);

        RoutineFactory factory1 = new RoutineFactory();
        Routine routine1 = factory1.create("Routine1");
        addRoutineDataAccessInterface.addRoutine(routine1);

        RoutineFactory factory2 = new RoutineFactory();
        Routine routine2 = factory2.create("Routine1");
        addRoutineDataAccessInterface.addRoutine(routine2);

        AddRoutineOutputBoundary failurePresenter = new AddRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(AddRoutineOutputData routine) {
                fail("Use case success is unexpected.");
            }
            @Override
            public void prepareFailView(String error) {
                assertEquals("Routine name already exists.", error);
            }
        };
        AddRoutineInputBoundary interactor = new AddRoutineInteractor(addRoutineDataAccessInterface, failurePresenter, new RoutineFactory());
        interactor.execute(repeatInput);
    }
}