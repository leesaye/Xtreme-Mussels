package use_case.add_routine_test;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.RoutineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_routine.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class AddRoutineInteractorTest {

    ArrayList<String> instructions;
    Exercise excercise = new Exercise("excerciseName", "arms", "equipments", instructions, "13", 3, 5);
    ArrayList excerciseList = new ArrayList<>();

    AddRoutineDataAccessInterface dataAccess;
    //    String routineName;
//    AddRoutineDataAccessInterface dataAccess;
//    HashMap<String, Routine> routineList = new HashMap<>();
//    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();
//
    @BeforeEach
    void init() {
        dataAccess = new RoutineDataAccessObject();
//        excerciseList.add(excercise);
//        RoutineDataAccessObject routineDataAccessObject;
//        routineDataAccessObject.setPath("TestRoutineFile.json");
//        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
//        routineList = routineDataAccessObject.getRoutineList();
    }

    //
    @Test
    void successTest() {

        AddRoutineInputData inputData = new AddRoutineInputData("routine 1");
        AddRoutineDataAccessInterface routineDataAccessInterface = new RoutineDataAccessObject();
        RoutineFactory routineFactory = new RoutineFactory();
        AddRoutineOutputBoundary addRoutinePresenter = new AddRoutineOutputBoundary() {

            @Override
            public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {
                // System.out.println(addRoutineOutputData.getRoutineName());
                assertEquals("routine 1", addRoutineOutputData.getRoutineName());
                assertFalse(routineDataAccessInterface.existsByName("routine 1"));
            }

            @Override
            public void prepareFailView(String message) {
                fail("Use case failure is unexpected.");
            }
        };

        AddRoutineInteractor interactor = new AddRoutineInteractor(dataAccess, addRoutinePresenter, routineFactory);
        interactor.execute(inputData);

    }

//    @Test
//    void failuretest() {
//        AddRoutineInputData inputData = new AddRoutineInputData("routine 1");
//        AddRoutineInputData inputData2 = new AddRoutineInputData("routine 1");
//        AddRoutineDataAccessInterface routineDataAccessInterface = new RoutineDataAccessObject();
//        RoutineFactory routineFactory = new RoutineFactory();
//        AddRoutineOutputBoundary addRoutinePresenter = new AddRoutineOutputBoundary() {
//            @Override
//            public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {
////                // System.out.println(addRoutineOutputData.getRoutineName());
////                assertEquals("routine 1", addRoutineOutputData.getRoutineName());
////                assertFalse(routineDataAccessInterface.existsByName("routine 1"));
//                fail("Use case success is unexpected.");
//            }
//
//            @Override
//            public void prepareFailView(String message) {
//                assertEquals("Routine name already exists.", message);
//            }
//        };
//        AddRoutineInteractor interactor = new AddRoutineInteractor(dataAccess, addRoutinePresenter, routineFactory);
//        interactor.execute(inputData2);
//    }
}
