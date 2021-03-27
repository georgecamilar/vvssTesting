package tasks.services;

import org.junit.jupiter.api.*;
import tasks.model.ArrayTaskList;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {

    private TasksService tasksService;

    @BeforeEach
    void setUp() {
        ArrayTaskList tasks = new ArrayTaskList();
        tasksService = new TasksService(tasks);
    }

    @Tag("ECP")
    //@Disabled
    @Test
    void addECPValid1() {
        try {
            tasksService.parseFromStringToSeconds("11:24");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("ECP")
    @RepeatedTest(3)
    void addECPValid2() {
        try {
            tasksService.parseFromStringToSeconds("00:59");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("ECP")
    @DisplayName("Test ECP pentru metoda parseFromStringToSeconds")
    @Test
    void addECPNonValid3() {
        try {
            tasksService.parseFromStringToSeconds("12:34:56");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("ECP")
    @Timeout(1000)
    @Test
    void addECPNonValid4(){
        try {
            tasksService.parseFromStringToSeconds("-9:34");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("ECP")
    @RepeatedTest(5)
    void addECPNonValid5(){
        try {
            tasksService.parseFromStringToSeconds("10:4b");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("ECP")
    @Test
    void addECPNonValid6(){
        try {
            tasksService.parseFromStringToSeconds("10:61");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("BVA")
    @Test
    void addBVAValid1() {
        try {
            tasksService.parseFromStringToSeconds("00:01");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("BVA")
    @Timeout(1000)
    //@Disabled
    @Test
    void addBVAValid2() {
        try {
            tasksService.parseFromStringToSeconds("23:59");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("BVA")
    @DisplayName("Test BVA pentru metoda parseFromStringToSeconds")
    @Test
    void addBVANonValid3() {
        try {
            tasksService.parseFromStringToSeconds("-1:59");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("BVA")
    @RepeatedTest(10)
    void addBVANonValid4() {
        try {
            tasksService.parseFromStringToSeconds("23:60");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }
}